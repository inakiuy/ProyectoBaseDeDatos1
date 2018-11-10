package proyectobasededatos1

class AuthController {

    Map login() {
        println 'hoolaaa'
        session.userAccountResponse = [name:'Gaspar']
        session.userAuthenticationResponse =  [key:'test']
        redirect (controller: 'dashboard', action: 'index')
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
