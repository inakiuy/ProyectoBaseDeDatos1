
<%@ page import="proyectobasededatos1.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/dashboard')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-user" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list user">


				<g:if test="${user?.id}">
					<g:hiddenField name="idUser" value="${user?.id}"></g:hiddenField>
				</g:if>

				<g:if test="${user?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="user.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label">
							<g:textField name="userEmail" id="userEmail" value="${user.email}" />
						</span>
					
				</li>
				</g:if>
			
				<g:if test="${user?.lastname}">
				<li class="fieldcontain">
					<span id="lastname-label" class="property-label"><g:message code="user.lastname.label" default="Lastname" /></span>
					
						<span class="property-value" aria-labelledby="lastname-label">
							<g:textField name="userLastName" id="userLastName" value="${user.lastname}" />
						</span>
					
				</li>
				</g:if>
			
				<g:if test="${user?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="user.name.label" default="Name" /></span>
						<span class="property-value" aria-labelledby="name-label">
							<g:textField name="userName" id="userName" value="${user.name}" />
						</span>
					
				</li>
				</g:if>

			
				<g:if test="${user?.phone}">
				<li class="fieldcontain">
					<span id="phone-label" class="property-label"><g:message code="user.phone.label" default="Phone" /></span>
						<span class="property-value" aria-labelledby="phone-label">
							<g:textField name="userPhone" id="userPhone" value="${user.phone}" />
						</span>
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:user, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<a href="#"  id="editUser">
						<g:message code="default.button.edit.label" default="Edit" />
					</a>

					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
