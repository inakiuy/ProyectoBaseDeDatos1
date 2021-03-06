package proyectobasededatos1

import com.ucu.bd.DataBaseProxy

import groovy.sql.Sql

import javax.sql.DataSource
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Statement

class DataService {

    DataSource dataSource

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


    Map getOrganizerType (id) {

        String query = """

       SELECT id, name, description
        FROM public.organizer_type WHERE id = ?;

        """

        Map organizerType = [:]
        Connection connection = dataSource.getConnection()
        PreparedStatement statement = connection.prepareStatement(query)
        statement.setLong(1, id as Long)
        println(statement)
        ResultSet resultSet = statement.executeQuery()
        if (resultSet.rows.size > 0) {
            while (resultSet.next()) {
                organizerType.id = resultSet.getInt(1)
                organizerType.name = resultSet.getString(2)
                organizerType.description = resultSet.getString(3)
            }
        }
        println(organizerType)

        return organizerType

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
                Map organizerType = getOrganizerType(resultSet.getInt(4))
                organizer.type = organizerType.name
                organizers.add(organizer)
            }
        }
        println(organizers)

        return organizers

    }

    Map getOrganizerById (id, userId) {
        String query = """

        SELECT *
        FROM    public.organizer       
        WHERE   id = ?

        """

        String queryOrgElement = """

        SELECT  el.*
            FROM    public.element el
            INNER JOIN public.organizer org
                ON org.id = el.organizer_id
                WHERE org.id = ?

        """

        Map organizer = [:]
        Connection connection = dataSource.getConnection()
        PreparedStatement statement = connection.prepareStatement(query)
        statement.setLong(1, id as Long)
        println(statement)
        ResultSet resultSet = statement.executeQuery()
        if (resultSet.rows.size > 0) {
            while (resultSet.next()) {
                organizer.id = resultSet.getInt(1)
                organizer.description = resultSet.getString(2)
                organizer.name = resultSet.getString(3)
                organizer.type = resultSet.getInt(4)
            }
        }
        println(organizer)


        PreparedStatement statement2 = connection.prepareStatement(queryOrgElement)
        statement2.setLong(1, organizer.id as Long)
        println(statement)
        ResultSet resultSet2 = statement2.executeQuery()
        List elements = []
        if (resultSet2.rows.size > 0) {
            while (resultSet2.next()) {
                Map element = [:]
                element.id = resultSet2.getLong(1)
                element.name = resultSet2.getString(3)
                element.description = resultSet2.getString(2)
                elements.add(element)
            }
        }

        List users = getUsers(userId)

        organizer.elements = []
        organizer.users = []
        organizer.users = users
        organizer.elements = elements

        println(organizer)

        return organizer
    }

    Map getElementById (id) {
        String query = """

        SELECT *
        FROM    public.element       
        WHERE   id = ?

        """

        String queryOrgElement = """

       SELECT eld.*
        FROM    public.element_detail eld
            INNER JOIN public.element el
            ON eld.element_id = el.id
            WHERE   el.id = ?

        """

        Map element = [:]
        Connection connection = dataSource.getConnection()
        PreparedStatement statement = connection.prepareStatement(query)
        statement.setLong(1, id as Long)
        println(statement)
        ResultSet resultSet = statement.executeQuery()
        if (resultSet.rows.size > 0) {
            while (resultSet.next()) {
                element.id = resultSet.getInt(1)
                element.description = resultSet.getString(2)
                element.name = resultSet.getString(3)
            }
        }

        println(element)

        List elementDetails = []
        PreparedStatement statement2 = connection.prepareStatement(queryOrgElement)
        statement2.setLong(1, id as Long)
        println(statement2)
        ResultSet resultSet2 = statement2.executeQuery()
        List elements = []
        if (resultSet2.rows.size > 0) {
            while (resultSet2.next()) {
                Map elementDetail = [:]
                elementDetail.id = resultSet2.getLong(1)
                elementDetail.name = resultSet2.getString(4)
                elementDetail.value = resultSet2.getString(5)
                elementDetails.add(elementDetail)
            }
        }

        element.elementDetails = []
        element.elementDetails = elementDetails

        return element
    }

    void updateOrganizerById (def organizer) {
        String query = """

        UPDATE public.organizer
        SET description=?, "name"=?, organizer_type_id=?
        WHERE id= ?;

        """

        Connection connection = dataSource.getConnection()
        PreparedStatement statement = connection.prepareStatement(query)
        statement.setString(1, organizer.description)
        statement.setString(2, organizer.name)
        statement.setLong(3, 1)
        statement.setLong(4, organizer.id as Long)
        println(statement)
        Integer result = statement.executeUpdate()
        println(result)
    }


    void updateElementById (def element) {
        String query = """

        UPDATE public.element
        SET description=?, "name"=?
        WHERE id= ?;

        """

        Connection connection = dataSource.getConnection()
        PreparedStatement statement = connection.prepareStatement(query)
        statement.setString(1, element.description)
        statement.setString(2, element.name)
        statement.setLong(3, element.id as Long)
        println(statement)
        Integer result = statement.executeUpdate()
        println(result)
    }

    void updateUserById(def user) {
        String query = """

        UPDATE public.user
        SET name=?, phone=?, email=?
        WHERE id= ?;

        """

        Connection connection = dataSource.getConnection()
        PreparedStatement statement = connection.prepareStatement(query)
        statement.setString(1, user.name)
        statement.setString(2, user.phone)
        statement.setString(3, user.email)
        statement.setLong(4, user.id as Long)
        println(statement)
        Integer result = statement.executeUpdate()
        println(result)

    }

    void createElement (def data) {

        String query = """
          INSERT INTO public.element(
            description, name, organizer_id, element_type_id)
                VALUES ( ?, ?, ?, ?);
        """

        Connection connection = dataSource.getConnection()
        PreparedStatement statement = connection.prepareStatement(query)
        statement.setString(1, data.description)
        statement.setString(2, data.name)
        statement.setLong(3, data.idOrganizer as Long)
        statement.setLong(4, 1)
        println(statement)
        Boolean result = statement.execute()

    }

    void shareOrganizer (def data) {

        String query = """
          INSERT INTO public.user_organizer_role(
            user_id, organizer_id, role_id)
                VALUES (?, ?, ?);
        """

        Connection connection = dataSource.getConnection()
        PreparedStatement statement = connection.prepareStatement(query)
        statement.setLong(1, data.userIdToShare as Long)
        statement.setLong(2, data.idOrganizer as Long)
        statement.setLong(3, 2)
        println(statement)
        Boolean result = statement.execute()

    }

    void createOrganizer (def organizer) {

        String query = """
        INSERT INTO public.organizer(
          description, name, organizer_type_id)
            VALUES (?, ?, ?);

        """

        String queryAsociateOrgAndUser = """
            INSERT INTO public.user_organizer_role(user_id, organizer_id, role_id) 
                VALUES (?, ?, ?);
        """

        Connection connection = dataSource.getConnection()
        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)
        statement.setString(1, organizer.description)
        statement.setString(2, organizer.name)
        statement.setLong(3, 1)
        println(statement)
        Boolean result = statement.execute()
        ResultSet rs = statement.getGeneratedKeys();
        int generatedKey = 0;
        if (rs.next()) {
            generatedKey = rs.getLong(1);
        }

        PreparedStatement statement2 = connection.prepareStatement(queryAsociateOrgAndUser, Statement.RETURN_GENERATED_KEYS)
        statement2.setLong(1, 1)
        statement2.setLong(2,generatedKey)
        statement2.setLong(3, 1)
        println(statement2)
        Boolean result2 = statement2.execute()

        println(result2)
    }


    void createUser (user) {
        String query = """
        
        INSERT  INTO public."user"(name, last_name, phone, email, password)
              VALUES (?, ?, ?, ?, ?);
        """

        Connection connection = dataSource.getConnection()
        PreparedStatement statement = connection.prepareStatement(query)
        statement.setString(1, user.name)
        statement.setString(2, user.lastName)
        statement.setString(3, user.phone)
        statement.setString(4, user.email)
        statement.setString(5, user.password)
        println(statement)
        Boolean result = statement.execute()
    }

    List getUsers(currentUserId){
        String query = """

    SELECT id, email, last_name, name
      FROM public."user" where id != ?;

        """

        List users = []
        Connection connection = dataSource.getConnection()
        PreparedStatement statement = connection.prepareStatement(query)
        statement.setLong(1, currentUserId)
        println(statement)
        ResultSet resultSet = statement.executeQuery()
        if (resultSet.rows.size > 0) {
            while (resultSet.next()) {
                Map user = [:]
                user.id = resultSet.getString(1)
                user.email = resultSet.getString(2)
                user.lastname = resultSet.getString(3)
                user.name = resultSet.getString(4)
                user.nameAndLastName = "${user.name} ${user.lastname}"
                users.add(user)
            }
        }
        println(users)

        return users
    }


    List getRoles(){
        String query = """

    SELECT id, description, name
      FROM public."role";

        """

        List roles = []
        Connection connection = dataSource.getConnection()
        PreparedStatement statement = connection.prepareStatement(query)
        println(statement)
        ResultSet resultSet = statement.executeQuery()
        if (resultSet.rows.size > 0) {
            while (resultSet.next()) {
                Map role = [:]
                role.id = resultSet.getString(1)
                role.description = resultSet.getString(2)
                role.name = resultSet.getString(3)
                roles.add(role)
            }
        }
        println(roles)

        return roles
    }


    Map getUserById(userId) {
        String query = """

        SELECT *
        FROM    public.user       
        WHERE   id = ?

        """

        Map user = [:]
        Connection connection = dataSource.getConnection()
        PreparedStatement statement = connection.prepareStatement(query)
        statement.setLong(1, userId as Long)
        println(statement)
        ResultSet resultSet = statement.executeQuery()
        if (resultSet.rows.size > 0) {
            while (resultSet.next()) {
                user.id = resultSet.getInt(1)
                user.name = resultSet.getString(2)
                user.lastname = resultSet.getString(3)
                user.phone = resultSet.getString(4)
                user.email = resultSet.getString(5)
            }
        }
        println(user)

        return user

    }


    void deleteOrganizer(data){

        String query = """
                SELECT public."DeleteOrganizer"(?,?)
        """

        Map user = [:]
        Connection connection = dataSource.getConnection()
        PreparedStatement statement = connection.prepareStatement(query)
        statement.setLong(1, data.idUser as Long)
        statement.setLong(2, data.idOrganizer as Long)
        println(statement)
        ResultSet resultSet = statement.executeQuery()

    }


    void deleteElement(data){

        String query = """
                SELECT public."DeleteElement"(?,?)
        """

        Map user = [:]
        Connection connection = dataSource.getConnection()
        PreparedStatement statement = connection.prepareStatement(query)
        statement.setLong(1, data.idUser as Long)
        statement.setLong(2, data.idElement as Long)
        println(statement)
        ResultSet resultSet = statement.executeQuery()

    }

    void deleteUser(data){
        String query = """
               SELECT public."DeleteUser"(?)
        """

        Map user = [:]
        Connection connection = dataSource.getConnection()
        PreparedStatement statement = connection.prepareStatement(query)
        statement.setLong(1, data.idUser as Long)
        println(statement)
        ResultSet resultSet = statement.executeQuery()

    }

    List searchElement (searchQuery, userId) {
        String query = """
                SELECT el.*
                  FROM  public.element el
                    INNER JOIN public.organizer org
                      ON org.id = el.organizer_id
                    INNER JOIN public.user_organizer_role uor
                      ON uor.organizer_id = org.id
                    WHERE uor.user_id = ?
                and (LOWER(el.name) LIKE LOWER(?) AND LOWER(el.description) LIKE LOWER(?))
        """

        List elements = []

        Connection connection = dataSource.getConnection()
        PreparedStatement statement = connection.prepareStatement(query)
        statement.setLong(1, userId as Long)
        statement.setString(2, "%" + searchQuery + "%")
        statement.setString(3, "%" + searchQuery + "%")
        println(statement)
        ResultSet resultSet = statement.executeQuery()
        if (resultSet.rows.size > 0) {
            while (resultSet.next()) {
                Map element = [:]
                element.id = resultSet.getString(1)
                element.description = resultSet.getString(2)
                element.name = resultSet.getString(3)
                elements.add(element)
            }
        }

        return elements
    }

}
