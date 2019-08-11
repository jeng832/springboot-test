'use strict';
$(document).ready(() => {
	
    $('#couponTable').DataTable({
    	pageLength: 3,
    	bPaginate: true,
    	bLengthChange: true,
    	lengthMenu : [3, 5, 10],
        bAutoWidth: false,
        processing: true,
        serverSide: true,
        ordering: false,
        searching: false,
        ajax: {
        	'url': '/hello/user',
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