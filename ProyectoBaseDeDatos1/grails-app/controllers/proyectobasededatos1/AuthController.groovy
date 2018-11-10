package proyectobasededatos1

class AuthController {

    DataService dataService

    Map login() {
        def exists = dataService.getUserByEmail(params.email, params.password)
        if (exists) {
            session.userAccountResponse = exists
            redirect (controller: 'dashboard', action: 'index')
        } else {
            request.test = true
            redirect(uri:'/', params: [succes: "true"])
        }
    }

    /**
     * Accion encargada de realizar el proceso de salida de la aplicacion para un usuario.
     */
    def logout = {
        //Invalidamos la session.
        session.invalidate()
        redirect(uri:'/')
    }
}
