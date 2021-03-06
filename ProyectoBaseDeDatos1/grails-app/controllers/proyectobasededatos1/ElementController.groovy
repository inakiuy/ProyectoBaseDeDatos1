package proyectobasededatos1

import grails.converters.JSON

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ElementController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "POST"]

    DataService dataService

    def index() {
        Map userLogged = session.userAccountResponse
        List users = []
        if (userLogged){
            users = dataService.getUsers(userLogged.id)
        }
        render(view: "index", model: [users: users])
    }

    def show() {
        Map element = dataService.getElementById(params.id)
        Map userLogged = session.userAccountResponse
        element.hasProperty = false
        [element: element, idOrganizer: params.idOrganizer, idUser: userLogged.id]
    }

    def create() {
        respond new Element(params)
    }

    @Transactional
    def save() {
        def data = request.JSON
        dataService.createElement(data)

        render [:] as JSON
    }


    @Transactional
    def edit() {
        def data = request.JSON
        dataService.updateElementById(data)

        render [:] as JSON
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
    def delete() {
        def data = request.JSON
        dataService.deleteElement(data)

        render [:] as JSON

    }

    def search() {
        def data = request.JSON
        Map userLogged = session.userAccountResponse
        def result = []
        Boolean existsData = true
        String htmlContentSearchResult
        if (userLogged){
            result = dataService.searchElement(data.searchQuery, userLogged.id)
            htmlContentSearchResult = g.render([template: 'elementResult' , model: [elements: result]])
        }

        if (result.empty){
            existsData = false
        }

        Map responseData = [existsData: existsData,
                            htmlContent: htmlContentSearchResult]

        render responseData as JSON
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
