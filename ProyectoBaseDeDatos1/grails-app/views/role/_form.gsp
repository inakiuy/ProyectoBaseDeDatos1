<%@ page import="proyectobasededatos1.Role" %>



<div class="fieldcontain ${hasErrors(bean: roleInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="role.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${roleInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: roleInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="role.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${roleInstance?.name}"/>

</div>

