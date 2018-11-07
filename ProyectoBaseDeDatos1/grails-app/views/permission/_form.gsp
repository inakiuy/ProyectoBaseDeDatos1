<%@ page import="proyectobasededatos1.Permission" %>



<div class="fieldcontain ${hasErrors(bean: permissionInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="permission.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${permissionInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: permissionInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="permission.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${permissionInstance?.name}"/>

</div>

