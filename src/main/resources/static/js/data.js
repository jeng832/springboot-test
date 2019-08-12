'use strict';
$(document).ready(() => {
	
    $('#couponTable').DataTable({
    	paging: true,
    	pageLength: 3,
    	paginType: "simple",
    	"lengthMenu" : [ [ 3, 5, 10, -1 ], [ 3, 5, 10, "All" ] ],
        processing: true,
        serverSide: true,
        searching: true,
        ordering: false,
        ajax: {
        	'url': '/hello/server/user',
        	'type': 'POST'
        	
        },
        columns: [
            {"data": "uid"},
            {"data": "user_name"},
            
            {"data": "created_time"}
        ]
    });

    $('#couponForm').submit((e) => {
    	e.preventDefault();
    	$('#couponTable').DataTable().ajax.reload(null, false);
    });

});