import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by gaspar.medina on 8/11/2018.
 */
public class ConnectionDataSource {

    public static final String URL = "jdbc:mysql://localhost:3306/testdb";
    public static final String USER = "testuser";
    public static final String PASS = "testpass";


    public static void main(String args[]) {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://10.8.0.1:5432/bd-ucu",
                            "gaspar", "g4sp4rvpn");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

}
