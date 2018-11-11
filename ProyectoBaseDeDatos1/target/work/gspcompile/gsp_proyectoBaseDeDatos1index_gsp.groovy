import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_proyectoBaseDeDatos1index_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',4,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',4,[:],2)
printHtmlPart(3)
expressionOut.print(request.contextPath)
printHtmlPart(4)
expressionOut.print(request.contextPath)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',11,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('field','g',21,['type':("text"),'id':("email"),'name':("email"),'class':("form-control"),'placeholder':("Email"),'required':(""),'autofocus':("")],-1)
printHtmlPart(9)
invokeTag('passwordField','g',24,['name':("password"),'class':("form-control"),'placeholder':("Contraseña"),'required':("")],-1)
printHtmlPart(10)
})
invokeTag('form','g',29,['controller':("auth"),'action':("login"),'name':("formUserLogin"),'class':("form-signin")],2)
printHtmlPart(1)
if(true && (params && request.test)) {
printHtmlPart(11)
}
printHtmlPart(12)
})
invokeTag('captureBody','sitemesh',37,[:],1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1541859200758L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
