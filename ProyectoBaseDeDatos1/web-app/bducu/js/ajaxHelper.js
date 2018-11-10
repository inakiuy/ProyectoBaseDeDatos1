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

});