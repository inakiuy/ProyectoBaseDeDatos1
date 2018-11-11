package proyectobasededatos1



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ElementDetailController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ElementDetail.list(params), model:[elementDetailInstanceCount: ElementDetail.count()]
    }

    def show(ElementDetail elementDetailInstance) {
        respond elementDetailInstance
    }

    def create() {
        respond new ElementDetail(params)
    }

    @Transactional
    def save(ElementDetail elementDetailInstance) {
        if (elementDetailInstance == null) {
            notFound()
            return
        }

        if (elementDetailInstance.hasErrors()) {
            respond elementDetailInstance.errors, view:'create'
            return
        }

        elementDetailInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'elementDetail.label', default: 'ElementDetail'), elementDetailInstance.id])
                redirect elementDetailInstance
            }
            '*' { respond elementDetailInstance, [status: CREATED] }
        }
    }

    def edit(ElementDetail elementDetailInstance) {
        respond elementDetailInstance
    }

    @Transactional
    def update(ElementDetail elementDetailInstance) {
        if (elementDetailInstance == null) {
            notFound()
            return
        }

        if (elementDetailInstance.hasErrors()) {
            respond elementDetailInstance.errors, view:'edit'
            return
        }

        elementDetailInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ElementDetail.label', default: 'ElementDetail'), elementDetailInstance.id])
                redirect elementDetailInstance
            }
            '*'{ respond elementDetailInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ElementDetail elementDetailInstance) {

        if (elementDetailInstance == null) {
            notFound()
            return
        }

        elementDetailInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ElementDetail.label', default: 'ElementDetail'), elementDetailInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'elementDetail.label', default: 'ElementDetail'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
