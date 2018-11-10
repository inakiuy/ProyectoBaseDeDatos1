package proyectobasededatos1

class DashboardController {

    DataService dataService

    def index() {

       Map userLogged = session.userAccountResponse
        if (userLogged){

            List organizers = dataService.getOrganizerByUserId(userLogged.id)
            [organizers: organizers]
        }


    }
}
