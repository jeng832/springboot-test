'use strict';

let api = (() => {

    const _BASE_PREFIX = '/hello/user/';

    function _findAll(param, callback) {
        $.ajax({
            url: _BASE_PREFIX,
            method: 'get',
            dataType: 'json'
        }).then((response) => {
        	alert('2');
            callback(null, response);
        }).catch((response) => {
        	alert('4');
            let responseJSON = response.responseJSON;
            let message = responseJSON.message;
            callback(message, responseJSON);
        });
    }

    function _create(param, callback) {
        $.ajax({
            url: _BASE_PREFIX,
            method: 'post',
            data: JSON.stringify(param),
            contentType: "application/json",
            dataType: 'json'
        }).then((response) => {
            callback(null, response);
        }).catch((response) => {
            let responseJSON = response.responseJSON;
            let message = responseJSON.message;
            callback(message, responseJSON);
        });
    }

    return {
        findAll: _findAll,
        create: _create
    }
})();