<%@ page import="proyectobasededatos1.Element" %>



<div class="fieldcontain ${hasErrors(bean: elementInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="element.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${elementInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: elementInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="element.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${elementInstance?.name}"/>

</div>

