import proyectobasededatos1.Element
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_proyectoBaseDeDatos1_element_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/element/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: elementInstance, field: 'description', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("element.description.label"),'default':("Description")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("description"),'required':(""),'value':(elementInstance?.description)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: elementInstance, field: 'name', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("element.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',19,['name':("name"),'required':(""),'value':(elementInstance?.name)],-1)
printHtmlPart(5)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1541559746963L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
