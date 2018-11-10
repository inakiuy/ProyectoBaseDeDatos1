package proyectobasededatos1

import com.ucu.bd.DataBaseProxy

import groovy.sql.Sql

import javax.sql.DataSource
import java.beans.Statement
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class DataService {

    DataSource dataSource

   // private static final String QUERY_GET_USERS = "SELECT $reqdColName FROM user"

    private static final String INSERT_USERS = """
         INSERT INTO User (name, lastname, phone, email, password) VALUES (?,?,?,?,?)'
    """

    private static final String TEST = '''
        SELECT "email" FROM user WHERE "email" = yagoauza@hotmail.com
    '''

    def getUserByEmail (email) {

       Connection connection = dataSource.getConnection()
       PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.user where email = 'yagoauza@hotmail.com'")
        println(statement)
        ResultSet resultSet = statement.executeQuery()
        while (resultSet.next()) {
            println(resultSet.getInt(1))
        }
    }


    def getUsers () {
        DataBaseProxy dataBaseProxy = new DataBaseProxy()

        Sql sql = dataBaseProxy.connect()

        List rows = sql.rows(QUERY_GET_USERS)

        println rows
    }

    def insertUser (Map user) {
//        Connection connection = dataSource.getConnection()
//        PreparedStatement statement
//        statement = connection.prepareStatement(QUERY_GET_USERS)
//        ResultSet resultSet = statement.executeQuery()
//
//        println(resultSet)

        //def reqdColName = "name"
        def query = "select * from permission"

        Sql sql = new Sql(dataSource)

        def list= sql.rows(query)

        println(list)

       // def array = sql.executeQuery(query).getArray(reqdColName)
       // def personList = Arrays.asList(array)
      //  println(personList)

//        sql.eachRow(QUERY_GET_USERS) {
//            println(it)
//        }

        //DataBaseProxy dataBaseProxy = new DataBaseProxy()
        //Sql sql = dataBaseProxy.connect()
        //Boolean ok = sql.execute(user, INSERT_USERS)
        //return ok
    }


}
