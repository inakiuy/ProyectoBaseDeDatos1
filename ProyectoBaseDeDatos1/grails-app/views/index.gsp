<!DOCTYPE html>
<html>
<head>
	<title>Organizadores | Iniciar Sesion</title>
	<!-- COMIENZO ESTILOS CSS-->
	<link rel='stylesheet prefetch'
		  href='${request.contextPath}/bducu/css/bootstrap.min.css'>
	<link href="${request.contextPath}/bducu/css/loginIndexStyle.css"
		  rel="stylesheet">
	<!-- FIN ESTILOS CSS-->
</head>
<body>

<div class="wrapper">
	<g:form controller="auth" action="login" name="formUserLogin"
			class="form-signin">

		<h2 class="form-signin-heading">Inicar sesión</h2>

		<g:field type="text" id="email" name="email" class="form-control"
				 placeholder="Email" required="" autofocus="" />

		<g:passwordField name="password" class="form-control"
						 placeholder="Contraseña" required="" />

		<button class="btn btn-lg btn-primary btn-block" type="submit">Iniciar Sesion</button>

		<br>
		<br>
		<div>
			<g:link controller="user" action="create" style="margin-left: 98px;" params="[register:true]">Registrar usuario</g:link>
		</div>
	</g:form>




	<g:if test="${params && request.test}">
		<div class="alert alert-danger alert-error">
			<strong>La contrase&ntilde;a y/o usuario que ingresaste es incorrecta.</strong>
		</div>
	</g:if>
</div>

</body>
</html>