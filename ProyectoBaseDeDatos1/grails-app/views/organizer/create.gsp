<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'organizer.label', default: 'Organizer')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-organizer" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/dashboard')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="create-organizer" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${organizerInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${organizerInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:organizerInstance, action:'save']" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<a href="#"  id="createOrganizer">
						<g:message code="default.button.create.label" default="Crear" />
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
			<g:each in="${organizer?.elements}">
				<tr class="even">
					<td>${it.description}</td>
					<td><g:link action="show" >${it.name}</g:link></td>
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
