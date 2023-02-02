import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;

public class SQLHandling {
    public static ArrayList<String> UserDetails = new ArrayList<>();


    public static void SQLLogin() {
        String DatabaseLocation = System.getProperty("user.dir")+"\\CourseworkDatabase.accdb";

        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");

            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "SELECT * FROM UserDetails";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next())   {
                //System.out.println("Username: " + rs.getString("Username"));
                UserDetails.add(rs.getString("Username")+","+rs.getString("Password"));

            }
            rs.close();
            con.close();




        } catch (Exception e) {
            System.out.println("Error in the SQL class:" + e);
        }

    }
    public static void SQLRegister(String RegisterUsername, String RegisterPassword) {
        String DatabaseLocation = System.getProperty("user.dir")+"\\CourseworkDatabase.accdb";

        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation);

            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);



            stmt.executeQuery("INSERT INTO UserDetails (Username, Password) VALUES ('"+RegisterUsername+","+ RegisterPassword+"')");



            con.close();




        } catch (Exception e) {
            System.out.println("Error in the SQL class:" + e);
        }

    }
}
