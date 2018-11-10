package proyectobasededatos1

import com.ucu.bd.DataBaseProxy

import groovy.sql.Sql

class DataService {

    private static final String QUERY_GET_USERS = """
                SELECT * FROM user
        """

    private static final String INSERT_USERS = """
         INSERT INTO User (name, lastname, phone, email, password) VALUES (?,?,?,?,?)'
    """

    def getUsers () {
        DataBaseProxy dataBaseProxy = new DataBaseProxy()

        Sql sql = dataBaseProxy.connect()

        List rows = sql.rows(QUERY_GET_USERS)

        println rows
    }

    def insertUser (Map user) {
        DataBaseProxy dataBaseProxy = new DataBaseProxy()
        Sql sql = dataBaseProxy.connect()
        Boolean ok = sql.execute(user, INSERT_USERS)
        return ok
    }
}
