<%@ page import="proyectobasededatos1.ElementDetail" %>



<div class="fieldcontain ${hasErrors(bean: elementDetailInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="elementDetail.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${elementDetailInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: elementDetailInstance, field: 'value', 'error')} required">
	<label for="value">
		<g:message code="elementDetail.value.label" default="Value" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="value" required="" value="${elementDetailInstance?.value}"/>

</div>

