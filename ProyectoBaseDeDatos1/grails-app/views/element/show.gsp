
<%@ page import="proyectobasededatos1.Element" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'element.label', default: 'Element')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-element" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/dashboard')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" controller="organizer" action="show" id="${idOrganizer}">Volver a Organizador</g:link></li>

			</ul>
		</div>
		<div id="show-element" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list element">

                <g:if test="${element?.id}">
                    <g:hiddenField name="idElement" value="${element?.id}"></g:hiddenField>
                </g:if>
                <g:hiddenField name="idOrganizer" value="${idOrganizer}"></g:hiddenField>
                <g:hiddenField name="idUser" value="${idUser}"></g:hiddenField>

				<g:if test="${element?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="element.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label">
							<g:textField name="elementDescription" id="elementDescription" value="${element.description}" />

						</span>
					
				</li>
				</g:if>
			
				<g:if test="${element?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="element.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label">
							<g:textField name="elementName" id="elementName" value="${element.name}" />

						</span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:element, action:'delete']" method="DELETE">
				<fieldset class="buttons">
                    <a href="#" class="edit"  id="editElement">
                        <g:message code="default.button.edit.label" default="Edit" />
                    </a>
                    <a href="#" class="delete"  id="deleteElement">
                        <g:message code="default.button.delete.label" default="Delete" />
                    </a>
				</fieldset>
			</g:form>
		</div>


        <!-- LISTA DE DETALLE DE ELEMENTOS-->
        <div class="content scaffold-show" role="main">
        <h1>Detalles del elemento ${element?.name}</h1>
        <br>
        <table>
            <thead>
            <tr>
                <g:sortableColumn property="id" title="Id" />
                <g:sortableColumn property="name" title="${message(code: 'organizer.name.label', default: 'Name')}" />
                <g:sortableColumn property="value" title="Valor" />

            </tr>
            </thead>
            <tbody>
            <g:each in="${element.elementDetails}">
                <tr class="even">
                    <td><g:link controller="detailElement" action="show" id="${it.id}">${it.id}</g:link></td>
                    <td>${it.name}</td>
                    <td>${it.value}</td>
                </tr>
            </g:each>
            </tbody>
        </table>
      </div>
	</body>
</html>
