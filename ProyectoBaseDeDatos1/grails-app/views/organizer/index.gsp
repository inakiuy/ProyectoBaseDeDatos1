
<%@ page import="proyectobasededatos1.Organizer" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'organizer.label', default: 'Organizer')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-organizer" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/dashboard')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-organizer" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="description" title="${message(code: 'organizer.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'organizer.name.label', default: 'Name')}" />
					
					</tr>
				</thead>
				<tbody>
                 <g:each in="${organizers}">
					<tr class="even">
						<td>${it.description}</td>
						<td><g:link action="show" id="${it.id}">${it.name}</g:link></td>
					</tr>
				</g:each>
				</tbody>
			</table>
		</div>
	</body>

</html>
