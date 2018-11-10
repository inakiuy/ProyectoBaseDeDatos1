package proyectobasededatos1



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ElementController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        Map userLogged = session.userAccountResponse
        List users = []
        if (userLogged){
            users = dataService.getUsers(userLogged.id)
        }
        render(view: "index", model: [users: users])
    }

    def show(Element elementInstance) {
        respond elementInstance
    }

    def create() {
        respond new Element(params)
    }

    @Transactional
    def save(Element elementInstance) {
        if (elementInstance == null) {
            notFound()
            return
        }

        if (elementInstance.hasErrors()) {
            respond elementInstance.errors, view:'create'
            return
        }

        elementInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'element.label', default: 'Element'), elementInstance.id])
                redirect elementInstance
            }
            '*' { respond elementInstance, [status: CREATED] }
        }
    }

    def edit(Element elementInstance) {
        respond elementInstance
    }

    @Transactional
    def update(Element elementInstance) {
        if (elementInstance == null) {
            notFound()
            return
        }

        if (elementInstance.hasErrors()) {
            respond elementInstance.errors, view:'edit'
            return
        }

        elementInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Element.label', default: 'Element'), elementInstance.id])
                redirect elementInstance
            }
            '*'{ respond elementInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Element elementInstance) {

        if (elementInstance == null) {
            notFound()
            return
        }

        elementInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Element.label', default: 'Element'), elementInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'element.label', default: 'Element'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
