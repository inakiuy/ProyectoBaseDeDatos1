import proyectobasededatos1.ElementDetail
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_proyectoBaseDeDatos1_elementDetail_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/elementDetail/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: elementDetailInstance, field: 'name', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("elementDetail.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("name"),'required':(""),'value':(elementDetailInstance?.name)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: elementDetailInstance, field: 'value', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("elementDetail.value.label"),'default':("Value")],-1)
printHtmlPart(2)
invokeTag('textField','g',19,['name':("value"),'required':(""),'value':(elementDetailInstance?.value)],-1)
printHtmlPart(5)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1541963039141L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
