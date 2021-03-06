<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Gestor de Organizadores</title>
    <!-- Bootstrap core CSS -->
    <link rel='stylesheet prefetch'
          href='${request.contextPath}/bducu/css/bootstrap.min.css'>
    <link rel='stylesheet prefetch'
          href='${request.contextPath}/bducu/css/simple-sidebar.css'>
    <script src="${request.contextPath}/bducu/js/jquery.min.js"></script>
</head>
<body>
<div id="wrapper" class="toggled">
    <!-- Sidebar -->
    <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <li class="sidebar-brand">
                <a href="#">
                    Bienvenido ${session.userAccountResponse.name}  ${session.userAccountResponse.lastName}
                </a>
            </li>
            <li>
                <g:link controller="organizer">Organizadores</g:link>
            </li>
            <li>
                <g:link controller="role">Roles</g:link>
            </li>
            <li>
                <g:link controller="user">Usuarios</g:link>
            </li>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <li>
                <g:link style="color:blank;" controller="auth" action="logout">Cerrar Sesion</g:link>
            </li>
        </ul>
    </div>
    <!-- /#sidebar-wrapper -->
    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <h1>Mis Organizadores</h1>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Descripcion</th>
                    <th scope="col">Tipo Organizador</th>
                </tr>
                </thead>
                <tbody>
                <g:each in="${organizers}" var="organizer" status="i">
                    <tr>
                        <th scope="row">${organizer.id}</th>
                        <td>${organizer.name}</td>
                        <td>${organizer.description}</td>
                        <td>${organizer.type}</td>
                    </tr>
                </g:each>
                </tbody>
            </table>
        </div>
    </div>
    <br>
    <hr class="style1">
    <br>
    </div>
</div>


<div class="container" style=" margin-left: 256px;">
    <div class="row">
        <div class="col-lg-12">
            <h3>Busqueda de elementos</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-4 col-lg-offset-4">
            <input type="search" value="" class="form-control" placeholder="Nombre o descripcion" id="searchQuery">
            <div class="col-auto">
                <button class="btn btn-md btn-success" type="submit" style=" margin-left: 373px; margin-top: -56px; " id="seachButton">Buscar</button>
            </div>
        </div>
    </div>
    <div class="row" id="toAppend">

    </div>
</div>


<!-- /#wrapper -->
<!-- Bootstrap core JavaScript -->
<script src="${request.contextPath}/bducu/js/bootstrap.min.js"></script>
<script src="${request.contextPath}/bducu/js/ajaxHelper.js"></script>
<!-- Menu Toggle Script -->
<script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
</script>
</body>
</html>