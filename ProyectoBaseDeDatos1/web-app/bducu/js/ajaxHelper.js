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

    $('#seachButton').click(function(e) {
        var searchQuery = $("#searchQuery").val()
        $.ajax({
            "url" : 'http://localhost:8098/ProyectoBaseDeDatos1/element/search',
            "type" : "POST",
            "contentType" : "application/json; charset=utf-8",
            "data" : JSON.stringify({
                "searchQuery" : searchQuery
            }),
            "dataType" : "json",
            "success" : function success (response) {
                console.log(response)
                $("#toAppend").empty();
                if (response.existsData) {
                    $("#toAppend").append(response.htmlContent)
                } else {
                    $("#toAppend").append("<div> No se encontraron elementos </div>")
                }
                $('#tableElements').css('display', '')
            },
            "error" : function error (xhr) {
                console.log(xhr)
                console.log(xhr)
            }

        });
    });


    $('#deleteUser').click(function(e) {
        var idUser = $("#idUser").val()

        $.ajax({
            "url" : 'http://localhost:8098/ProyectoBaseDeDatos1/user/delete',
            "type" : "POST",
            "contentType" : "application/json; charset=utf-8",
            "data" : JSON.stringify({
                "idUser" : idUser
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

    $('#deleteElement').click(function(e) {
        var idElement = $("#idElement").val()
        var idOrganizer = $("#idOrganizer").val()
        var idUser = $("#idUser").val()


        $.ajax({
            "url" : 'http://localhost:8098/ProyectoBaseDeDatos1/element/delete',
            "type" : "POST",
            "contentType" : "application/json; charset=utf-8",
            "data" : JSON.stringify({
                "idElement" : idElement,
                "idUser" : idUser
            }),
            "dataType" : "json",
            "success" : function success (response) {
                console.log(response)
                window.location.replace('http://localhost:8098/ProyectoBaseDeDatos1/organizer/show/' + idOrganizer);
            },
            "error" : function error (xhr) {
                console.log(xhr)
            }

        });
    });

    $('#editElement').click(function(e) {
        var idElement = $("#idElement").val()
        var idOrganizer = $("#idOrganizer").val()
        var elementDescription = $("#elementDescription").val()
        var elementName = $("#elementName").val()

        $.ajax({
            "url" : 'http://localhost:8098/ProyectoBaseDeDatos1/element/edit',
            "type" : "POST",
            "contentType" : "application/json; charset=utf-8",
            "data" : JSON.stringify({
                "id" : idElement,
                "description" : elementDescription,
                "name" : elementName
            }),
            "dataType" : "json",
            "success" : function success (response) {
                console.log(response)
                window.location.replace('http://localhost:8098/ProyectoBaseDeDatos1/organizer/show/' + idOrganizer);

            },
            "error" : function error (xhr) {
                console.log(xhr)
            }

        });
    });

    $('#createElement').click(function(e) {
        var idOrganizer = $("#idOrganizer").val()
        var elementDescription = $("#description").val()
        var elementName = $("#name").val()


        $.ajax({
            "url" : 'http://localhost:8098/ProyectoBaseDeDatos1/element/save',
            "type" : "POST",
            "contentType" : "application/json; charset=utf-8",
            "data" : JSON.stringify({
                "name" : elementName,
                "description" : elementDescription,
                "idOrganizer" : idOrganizer
            }),
            "dataType" : "json",
            "success" : function success (response) {
                console.log(response)
                window.location.replace('http://localhost:8098/ProyectoBaseDeDatos1/organizer/show/' + idOrganizer);

            },
            "error" : function error (xhr) {
                console.log(xhr)
            }

        });
    });

    $('#shareOrganizer').click(function(e) {
        var idOrganizer = $("#idOrganizer").val()
        var userIdToShare = $('#user option:selected').val()
        $.ajax({
            "url" : 'http://localhost:8098/ProyectoBaseDeDatos1/organizer/share',
            "type" : "POST",
            "contentType" : "application/json; charset=utf-8",
            "data" : JSON.stringify({
                "userIdToShare" : userIdToShare,
                "idOrganizer" : idOrganizer
            }),
            "dataType" : "json",
            "success" : function success (response) {
                console.log(response)
                window.location.replace('http://localhost:8098/ProyectoBaseDeDatos1/organizer/show/' + idOrganizer);
            },
            "error" : function error (xhr) {
                console.log(xhr)
            }

        });
    });
});