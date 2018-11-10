<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Simple Sidebar - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
    <link rel='stylesheet prefetch'
          href='${request.contextPath}/bducu/css/bootstrap.min.css'>
    <link rel='stylesheet prefetch'
          href='${request.contextPath}/bducu/css/simple-sidebar.css'>

</head>

<body>

<div id="wrapper" class="toggled">

    <!-- Sidebar -->
    <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <li class="sidebar-brand">
                <a href="#">
                    Bienvenido Gaspar
                </a>
            </li>
            <li>
                <g:link controller="organizer">Organizadores</g:link>
            </li>
            <li>
                <g:link controller="permission">Permisos</g:link>
            </li>
            <li>
                <g:link controller="role">Roles</g:link>
            </li>
            <li>
                <g:link controller="user">Usuarios</g:link>
            </li>
            <li>
                <g:link controller="element">Elementos</g:link>
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
            <li>
                <g:link style="color:blank;" controller="auth" action="logout">Cerrar Sesion</g:link>
            </li>
        </ul>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <h1>Simple Sidebar</h1>
            <p>This template has a responsive menu toggling system. The menu will appear collapsed on smaller screens, and will appear non-collapsed on larger screens. When toggled using the button below, the menu will appear/disappear. On small screens, the page content will be pushed off canvas.</p>
            <p>Make sure to keep all page content within the <code>#page-content-wrapper</code>.</p>
            <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>
        </div>
    </div>
    <!-- /#page-content-wrapper -->

</div>
<!-- /#wrapper -->

<!-- Bootstrap core JavaScript -->
<script src="${request.contextPath}/bducu/js/bootstrap.min.js"></script>
<script src="${request.contextPath}/bducu/js/jquery.min.js"></script>

<!-- Menu Toggle Script -->
<script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
</script>

</body>

</html>