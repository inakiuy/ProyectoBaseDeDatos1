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

    Map getUserByEmail (email, password) {

        Map user = [:]
       Connection connection = dataSource.getConnection()
       PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.user where email ='" +  email + "' AND password ='" + password + "'")
        println(statement)
        ResultSet resultSet = statement.executeQuery()
        if (resultSet.rows.size > 0) {
            while (resultSet.next()) {
                user.id = resultSet.getInt(1)
                user.name = resultSet.getString(2)
                user.lastName = resultSet.getString(3)
                user.phone = resultSet.getString(4)
                user.phone = resultSet.getString(5)
            }
        }
       return user
    }


    List getOrganizerByUserId (userId) {

     String query = """

     SELECT org.*
        FROM    public.user_organizer_role usorrol

        INNER JOIN public.user us
        ON usorrol.user_id = us.id
        INNER JOIN public.role rol
        ON usorrol.role_id = rol.id
        INNER JOIN public.organizer org
        ON usorrol.organizer_id = org.id

        WHERE   us.id = ?

        """

        List organizers = []
        Connection connection = dataSource.getConnection()
        PreparedStatement statement = connection.prepareStatement(query)
        statement.setLong(1, userId)
        println(statement)
        ResultSet resultSet = statement.executeQuery()
        if (resultSet.rows.size > 0) {
            while (resultSet.next()) {
                Map organizer = [:]
                organizer.id = resultSet.getInt(1)
                organizer.description = resultSet.getString(2)
                organizer.name = resultSet.getString(3)
                organizer.type = resultSet.getInt(4)
                organizers.add(organizer)
            }
        }
        println(organizers)

        return organizers

    }

}
