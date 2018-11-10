
<%@ page import="proyectobasededatos1.Organizer" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'organizer.label', default: 'Organizer')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-organizer" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/dashboard')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-organizer" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list organizer">

				<g:if test="${organizer?.id}">
					<g:hiddenField name="idOrganizer" value="${organizer?.id}"></g:hiddenField>
				</g:if>
				<g:hiddenField name="idUser" value="${user?.id}"></g:hiddenField>

				<g:if test="${organizer?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="organizer.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label">
							<g:textField name="descriptionOrganizer" id="descriptionOrganizer" value="${organizer.description}" />
						</span>

				</li>
				</g:if>

				<g:if test="${organizer?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="organizer.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label">
							<g:textField name="nameOrganizer" id="nameOrganizer" value="${organizer.name}" />
						</span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:organizer, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<a href="#"  id="editOrganizer">
						<g:message code="default.button.edit.label" default="Edit" />
					</a>
					<a href="#"  id="deleteOrganizer">
						<g:message code="default.button.delete.label" default="Delete" />
					</a>

				</fieldset>
			</g:form>
		</div>
        <br>
	    <div class="content scaffold-show" role="main">
			<h1>Elementos del organizador ${organizer?.name}</h1>
			<br>
			<table>
				<thead>
				<tr>

					<g:sortableColumn property="description" title="${message(code: 'organizer.description.label', default: 'Description')}" />

					<g:sortableColumn property="name" title="${message(code: 'organizer.name.label', default: 'Name')}" />

				</tr>
				</thead>
				<tbody>
				<g:each in="${[1,2]}">
					<tr class="even">
						<td>lkjs</td>
						<td><g:link action="show" >jsad</g:link></td>
					</tr>
				</g:each>
				</tbody>
			</table>


		</div>
	    <br>
	    <div  class="content scaffold-show" role="main">
		<h1><g:message code="default.create.label" args="['Elemento']" /></h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
		</g:if>
		<ol class="property-list organizer">
			<fieldset class="form">
				<div class="fieldcontain ${hasErrors(bean: elementInstance, field: 'description', 'error')} required">
					<label for="description">
						<g:message code="element.description.label" default="Description" />
						<span class="required-indicator">*</span>
					</label>
					<g:textField name="description" required=""/>

				</div>

				<div class="fieldcontain ${hasErrors(bean: elementInstance, field: 'name', 'error')} required">
					<label for="name">
						<g:message code="element.name.label" default="Name" />
						<span class="required-indicator">*</span>
					</label>
					<g:textField name="name" required="" />

				</div>
			</fieldset>
		</ol>
		<g:form url="[resource:organizer, action:'delete']" method="DELETE">
			<fieldset class="buttons">
				<a href="#"  id="createElement">
					<g:message code="default.button.create.label" default="Crear" />
				</a>
			</fieldset>
		</g:form>
	</div>
	</body>

</html>
