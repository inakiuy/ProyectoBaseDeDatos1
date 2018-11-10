<%@ page import="proyectobasededatos1.Organizer" %>



<div class="fieldcontain ${hasErrors(bean: organizerInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="organizer.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${organizerInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: organizerInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="organizer.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${organizerInstance?.name}"/>

</div>

