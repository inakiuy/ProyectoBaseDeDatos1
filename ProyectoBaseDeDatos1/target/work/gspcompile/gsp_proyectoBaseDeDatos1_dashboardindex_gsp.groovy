import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_proyectoBaseDeDatos1_dashboardindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/dashboard/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1, shrink-to-fit=no")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("description"),'content':("")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("author"),'content':("")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
expressionOut.print(request.contextPath)
printHtmlPart(4)
expressionOut.print(request.contextPath)
printHtmlPart(5)
expressionOut.print(request.contextPath)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',15,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
expressionOut.print(session.userAccountResponse.name)
printHtmlPart(9)
expressionOut.print(session.userAccountResponse.lastName)
printHtmlPart(10)
createClosureForHtmlPart(11, 2)
invokeTag('link','g',27,['controller':("organizer")],2)
printHtmlPart(12)
createClosureForHtmlPart(13, 2)
invokeTag('link','g',30,['controller':("role")],2)
printHtmlPart(12)
createClosureForHtmlPart(14, 2)
invokeTag('link','g',33,['controller':("user")],2)
printHtmlPart(15)
createClosureForHtmlPart(16, 2)
invokeTag('link','g',55,['style':("color:blank;"),'controller':("auth"),'action':("logout")],2)
printHtmlPart(17)
loop:{
int i = 0
for( organizer in (organizers) ) {
printHtmlPart(18)
expressionOut.print(organizer.id)
printHtmlPart(19)
expressionOut.print(organizer.name)
printHtmlPart(20)
expressionOut.print(organizer.description)
printHtmlPart(20)
expressionOut.print(organizer.type)
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
expressionOut.print(request.contextPath)
printHtmlPart(23)
expressionOut.print(request.contextPath)
printHtmlPart(24)
})
invokeTag('captureBody','sitemesh',124,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1541954394869L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
