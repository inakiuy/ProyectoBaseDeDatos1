package proyectobasededatos1

import grails.converters.JSON

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class OrganizerController {

    DataService dataService

    static allowedMethods = [save: "POST", update: "PUT", delete: "POST"]

    def index(Integer max) {
        Map userLogged = session.userAccountResponse
        List organizers = []
        if (userLogged){
            organizers = dataService.getOrganizerByUserId(userLogged.id)
        }
        render(view: "index", model: [organizers: organizers])
    }

    def show() {
        Map organizer = dataService.getOrganizerById(params.id)
        Map userLogged = session.userAccountResponse
        organizer.hasProperty = false
        [organizer: organizer, user: userLogged]
    }

    def create() {
        respond new Organizer(params)
    }

    @Transactional
    def save() {
        def data = request.JSON
        dataService.createOrganizer(data)

        render [:] as JSON
    }

    @Transactional
    def edit() {
        def data = request.JSON
        dataService.updateOrganizerById(data)

        render [:] as JSON
    }

    @Transactional
    def update(Organizer organizerInstance) {
        if (organizerInstance == null) {
            notFound()
            return
        }

        if (organizerInstance.hasErrors()) {
            respond organizerInstance.errors, view:'edit'
            return
        }

        organizerInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Organizer.label', default: 'Organizer'), organizerInstance.id])
                redirect organizerInstance
            }
            '*'{ respond organizerInstance, [status: OK] }
        }
    }

    @Transactional
    def delete() {
        def data = request.JSON
        dataService.deleteOrganizer(data)

        render [:] as JSON

    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'organizer.label', default: 'Organizer'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
