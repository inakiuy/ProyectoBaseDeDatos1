import proyectobasededatos1.User
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_proyectoBaseDeDatos1_usershow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'user.label', default: 'User'))],-1)
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
if(true && (user?.id)) {
printHtmlPart(14)
invokeTag('hiddenField','g',28,['name':("idUser"),'value':(user?.id)],-1)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (user?.email)) {
printHtmlPart(17)
invokeTag('message','g',33,['code':("user.email.label"),'default':("Email")],-1)
printHtmlPart(18)
invokeTag('textField','g',36,['name':("userEmail"),'id':("userEmail"),'value':(user.email)],-1)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (user?.lastname)) {
printHtmlPart(21)
invokeTag('message','g',44,['code':("user.lastname.label"),'default':("Lastname")],-1)
printHtmlPart(22)
invokeTag('textField','g',47,['name':("userLastName"),'id':("userLastName"),'value':(user.lastname)],-1)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (user?.name)) {
printHtmlPart(23)
invokeTag('message','g',55,['code':("user.name.label"),'default':("Name")],-1)
printHtmlPart(24)
invokeTag('textField','g',57,['name':("userName"),'id':("userName"),'value':(user.name)],-1)
printHtmlPart(19)
}
printHtmlPart(25)
if(true && (user?.phone)) {
printHtmlPart(26)
invokeTag('message','g',66,['code':("user.phone.label"),'default':("Phone")],-1)
printHtmlPart(27)
invokeTag('textField','g',68,['name':("userPhone"),'id':("userPhone"),'value':(user.phone)],-1)
printHtmlPart(28)
}
printHtmlPart(29)
createTagBody(2, {->
printHtmlPart(30)
invokeTag('message','g',77,['code':("default.button.edit.label"),'default':("Edit")],-1)
printHtmlPart(31)
invokeTag('message','g',80,['code':("default.button.delete.label"),'default':("Delete")],-1)
printHtmlPart(32)
})
invokeTag('form','g',83,['url':([resource:user, action:'delete']),'method':("DELETE")],2)
printHtmlPart(33)
})
invokeTag('captureBody','sitemesh',85,[:],1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1541954964300L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
