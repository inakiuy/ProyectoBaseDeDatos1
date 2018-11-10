$(document).ready(function(){


    $('#editOrganizer').click(function(e) {
        var name = $("#nameOrganizer").val()
        var description = $("#descriptionOrganizer").val()
        var id = $("#idOrganizer").val()

        $.ajax({
            "url" : 'http://localhost:8098/ProyectoBaseDeDatos1/organizer/edit',
            "type" : "POST",
            "contentType" : "application/json; charset=utf-8",
            "data" : JSON.stringify({
                "name" : name,
                "description" : description,
                "id" : id
            }),
            "dataType" : "json",
            "success" : function success (response) {
                console.log(response)
                window.location.replace('http://localhost:8098/ProyectoBaseDeDatos1/organizer/index');

            },
            "error" : function error (xhr) {
                console.log(xhr)
            }

        });
    });

    $('#createOrganizer').click(function(e) {
        var name = $("#nameOrganizer").val()
        var description = $("#descriptionOrganizer").val()


        $.ajax({
            "url" : 'http://localhost:8098/ProyectoBaseDeDatos1/organizer/save',
            "type" : "POST",
            "contentType" : "application/json; charset=utf-8",
            "data" : JSON.stringify({
                "name" : name,
                "description" : description
            }),
            "dataType" : "json",
            "success" : function success (response) {
                console.log(response)
                window.location.replace('http://localhost:8098/ProyectoBaseDeDatos1/organizer/index');

            },
            "error" : function error (xhr) {
                console.log(xhr)
            }

        });
    });

    $('#createUser').click(function(e) {
        var email = $("#email").val()
        var lastName = $("#lastname").val()
        var password =  $("#password").val()
        var phone =  $("#phone").val()
        var name =  $("#name").val()

        $.ajax({
            "url" : 'http://localhost:8098/ProyectoBaseDeDatos1/user/save',
            "type" : "POST",
            "contentType" : "application/json; charset=utf-8",
            "data" : JSON.stringify({
                "email" : email,
                "lastName" : lastName,
                "password" : password,
                "phone" : phone,
                "name" : name
            }),
            "dataType" : "json",
            "success" : function success (response) {
                console.log(response)
                window.location.replace('http://localhost:8098/ProyectoBaseDeDatos1/user/index');

            },
            "error" : function error (xhr) {
                console.log(xhr)
            }

        });
    });

    $('#editUser').click(function(e) {
        var idUser = $("#idUser").val()
        var userEmail = $("#userEmail").val()
        var userName = $("#userName").val()
        var userPhone = $("#userPhone").val()

        $.ajax({
            "url" : 'http://localhost:8098/ProyectoBaseDeDatos1/user/edit',
            "type" : "POST",
            "contentType" : "application/json; charset=utf-8",
            "data" : JSON.stringify({
                "id" : idUser,
                "email" : userEmail,
                "name" : userName,
                "phone" : userPhone
            }),
            "dataType" : "json",
            "success" : function success (response) {
                console.log(response)
                window.location.replace('http://localhost:8098/ProyectoBaseDeDatos1/user/index');

            },
            "error" : function error (xhr) {
                console.log(xhr)
            }

        });
    });


    $('#deleteOrganizer').click(function(e) {
        var idOrganizer = $("#idOrganizer").val()
        var idUser = $("#idUser").val()

        $.ajax({
            "url" : 'http://localhost:8098/ProyectoBaseDeDatos1/organizer/delete',
            "type" : "POST",
            "contentType" : "application/json; charset=utf-8",
            "data" : JSON.stringify({
                "idOrganizer" : idOrganizer,
                "idUser" : idUser
            }),
            "dataType" : "json",
            "success" : function success (response) {
                console.log(response)
                window.location.replace('http://localhost:8098/ProyectoBaseDeDatos1/organizer/index');

            },
            "error" : function error (xhr) {
                console.log(xhr)
            }

        });
    });

});