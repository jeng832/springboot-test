'use strict';
$(document).ready(() => {
	
    $('#couponTable').DataTable({
    	paging: true,
    	pageLength: 3,
    	paginType: "simple",
        processing: false,
        bServerSide: false,
        ordering: false,
        ajax: {
        	'url': '/hello/client/user',
        	'type': 'GET'
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