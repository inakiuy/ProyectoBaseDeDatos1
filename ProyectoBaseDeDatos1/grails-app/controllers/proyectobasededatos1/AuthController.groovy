package proyectobasededatos1

class AuthController {

    DataService dataService

    Map login() {
        def exists = dataService.getUserByEmail(params.email)
        if (exists) {
            session.userAccountResponse = [name:'Gaspar']
            session.userAuthenticationResponse =  [key:'test']
            redirect (controller: 'dashboard', action: 'index')
        } else {
            println('No se puede entrar')
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
