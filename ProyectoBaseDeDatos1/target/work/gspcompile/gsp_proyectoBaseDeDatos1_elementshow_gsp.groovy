import proyectobasededatos1.Element
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_proyectoBaseDeDatos1_elementshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/element/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'element.label', default: 'Element'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/dashboard'))
printHtmlPart(6)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(7)
createClosureForHtmlPart(8, 2)
invokeTag('link','g',15,['class':("list"),'controller':("organizer"),'action':("show"),'id':(idOrganizer)],2)
printHtmlPart(9)
invokeTag('message','g',20,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (element?.id)) {
printHtmlPart(14)
invokeTag('hiddenField','g',27,['name':("idElement"),'value':(element?.id)],-1)
printHtmlPart(15)
}
printHtmlPart(15)
invokeTag('hiddenField','g',29,['name':("idOrganizer"),'value':(idOrganizer)],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',30,['name':("idUser"),'value':(idUser)],-1)
printHtmlPart(16)
if(true && (element?.description)) {
printHtmlPart(17)
invokeTag('message','g',34,['code':("element.description.label"),'default':("Description")],-1)
printHtmlPart(18)
invokeTag('textField','g',37,['name':("elementDescription"),'id':("elementDescription"),'value':(element.description)],-1)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (element?.name)) {
printHtmlPart(21)
invokeTag('message','g',46,['code':("element.name.label"),'default':("Name")],-1)
printHtmlPart(22)
invokeTag('textField','g',49,['name':("elementName"),'id':("elementName"),'value':(element.name)],-1)
printHtmlPart(19)
}
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
invokeTag('message','g',60,['code':("default.button.edit.label"),'default':("Edit")],-1)
printHtmlPart(25)
invokeTag('message','g',63,['code':("default.button.delete.label"),'default':("Delete")],-1)
printHtmlPart(26)
})
invokeTag('form','g',66,['url':([resource:element, action:'delete']),'method':("DELETE")],2)
printHtmlPart(27)
expressionOut.print(element?.name)
printHtmlPart(28)
invokeTag('sortableColumn','g',77,['property':("id"),'title':("Id")],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',78,['property':("name"),'title':(message(code: 'organizer.name.label', default: 'Name'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',79,['property':("value"),'title':("Valor")],-1)
printHtmlPart(29)
for( _it829893199 in (element.elementDetails) ) {
changeItVariable(_it829893199)
printHtmlPart(30)
createTagBody(3, {->
expressionOut.print(it.id)
})
invokeTag('link','g',86,['controller':("detailElement"),'action':("show"),'id':(it.id)],3)
printHtmlPart(31)
expressionOut.print(it.name)
printHtmlPart(31)
expressionOut.print(it.value)
printHtmlPart(32)
}
printHtmlPart(33)
})
invokeTag('captureBody','sitemesh',94,[:],1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1541962746245L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
