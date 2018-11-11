import proyectobasededatos1.Organizer
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_proyectoBaseDeDatos1_organizershow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/organizer/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'organizer.label', default: 'Organizer'))],-1)
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
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("list"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("create"),'action':("create")],2)
printHtmlPart(9)
invokeTag('message','g',20,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (organizer?.id)) {
printHtmlPart(14)
invokeTag('hiddenField','g',27,['name':("idOrganizer"),'value':(organizer?.id)],-1)
printHtmlPart(15)
}
printHtmlPart(15)
invokeTag('hiddenField','g',29,['name':("idUser"),'value':(user?.id)],-1)
printHtmlPart(16)
if(true && (organizer?.description)) {
printHtmlPart(17)
invokeTag('message','g',33,['code':("organizer.description.label"),'default':("Description")],-1)
printHtmlPart(18)
invokeTag('textField','g',36,['name':("descriptionOrganizer"),'id':("descriptionOrganizer"),'value':(organizer.description)],-1)
printHtmlPart(19)
}
printHtmlPart(16)
if(true && (organizer?.name)) {
printHtmlPart(20)
invokeTag('message','g',44,['code':("organizer.name.label"),'default':("Name")],-1)
printHtmlPart(21)
invokeTag('textField','g',47,['name':("nameOrganizer"),'id':("nameOrganizer"),'value':(organizer.name)],-1)
printHtmlPart(22)
}
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
invokeTag('message','g',57,['code':("default.button.edit.label"),'default':("Edit")],-1)
printHtmlPart(25)
invokeTag('message','g',60,['code':("default.button.delete.label"),'default':("Delete")],-1)
printHtmlPart(26)
})
invokeTag('form','g',64,['url':([resource:organizer, action:'delete']),'method':("DELETE")],2)
printHtmlPart(27)
expressionOut.print(organizer?.name)
printHtmlPart(28)
invokeTag('sortableColumn','g',76,['property':("description"),'title':(message(code: 'organizer.description.label', default: 'Description'))],-1)
printHtmlPart(29)
invokeTag('sortableColumn','g',78,['property':("name"),'title':(message(code: 'organizer.name.label', default: 'Name'))],-1)
printHtmlPart(30)
for( _it781503673 in (organizer.elements) ) {
changeItVariable(_it781503673)
printHtmlPart(31)
expressionOut.print(it.description)
printHtmlPart(32)
createTagBody(3, {->
expressionOut.print(it.name)
})
invokeTag('link','g',86,['controller':("element"),'action':("show"),'id':(it.id),'params':([idOrganizer: organizer?.id])],3)
printHtmlPart(33)
}
printHtmlPart(34)
invokeTag('message','g',96,['code':("default.create.label"),'args':(['Elemento'])],-1)
printHtmlPart(35)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(36)
}
printHtmlPart(37)
expressionOut.print(hasErrors(bean: elementInstance, field: 'description', 'error'))
printHtmlPart(38)
invokeTag('message','g',104,['code':("element.description.label"),'default':("Description")],-1)
printHtmlPart(39)
invokeTag('textField','g',107,['name':("description"),'required':("")],-1)
printHtmlPart(40)
expressionOut.print(hasErrors(bean: elementInstance, field: 'name', 'error'))
printHtmlPart(41)
invokeTag('message','g',113,['code':("element.name.label"),'default':("Name")],-1)
printHtmlPart(39)
invokeTag('textField','g',116,['name':("name"),'required':("")],-1)
printHtmlPart(42)
createTagBody(2, {->
printHtmlPart(43)
invokeTag('message','g',124,['code':("default.button.create.label"),'default':("Crear")],-1)
printHtmlPart(44)
})
invokeTag('form','g',127,['url':([resource:organizer, action:'delete']),'method':("DELETE")],2)
printHtmlPart(45)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(36)
}
printHtmlPart(37)
expressionOut.print(hasErrors(bean: elementInstance, field: 'description', 'error'))
printHtmlPart(46)
invokeTag('select','g',144,['from':(organizer.users),'optionKey':("id"),'optionValue':({it.nameAndLastName?.toUpperCase()}),'name':("user")],-1)
printHtmlPart(47)
createClosureForHtmlPart(48, 2)
invokeTag('form','g',156,['url':([resource:organizer, action:'delete']),'method':("DELETE")],2)
printHtmlPart(49)
})
invokeTag('captureBody','sitemesh',162,[:],1)
printHtmlPart(50)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1541965000400L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
