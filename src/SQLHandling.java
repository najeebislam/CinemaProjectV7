import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;
import java.util.Date;
import java.util.Objects;

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


    public static void SQLViewAccountDetails() {
        String DatabaseLocation = System.getProperty("user.dir")+"\\CourseworkDatabase.accdb";

        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");

            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String SQLLoginUsername = LoginRegister.LoginUsername;

            String sql = "SELECT * FROM UserDetails WHERE Username = '"+SQLLoginUsername+"'";

            ResultSet rs = stmt.executeQuery(sql);
            rs.next();

            System.out.println("Username: " + rs.getString("Username"));
            System.out.println("Password: " + rs.getString("Password"));
            System.out.println("Date of Birth: " + rs.getString("DateOfBirth"));



            rs.close();
            con.close();




        } catch (Exception e) {
            System.out.println("Error in the SQL class:" + e);
        }

    }
    public static void SQLRegister(String RegisterUsername, String RegisterPassword, String Date) {
        String DatabaseLocation = System.getProperty("user.dir")+"\\CourseworkDatabase.accdb";

        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation);

            //Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            Statement stmt = con.createStatement();



            stmt.execute("INSERT INTO UserDetails (Username, Password, DateOfBirth) VALUES ('"+RegisterUsername+"', '"+ RegisterPassword+"', '"+ Date+"')");



            con.close();




        } catch (Exception e) {
            System.out.println("Error in the SQL class:" + e);
        }

    }

    public static ArrayList<String> FilmDetails = new ArrayList<>();
    public static void SQLViewFilms() {
        String DatabaseLocation = System.getProperty("user.dir")+"\\CourseworkDatabase.accdb";
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");

            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "SELECT * FROM FilmDetails";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next())   {
                System.out.println("Film: " + rs.getString("FilmName"));
                System.out.println("Age Rating: " + rs.getString("AgeRating"));
                System.out.println("Film Length: " + rs.getString("FilmLength")+" minutes");
                System.out.println("Film Genre: " + rs.getString("FilmGenre"));
                System.out.println("Cast: " + rs.getString("FilmCast"));
                System.out.println("----------------------------------------------------------------------------------------");
                FilmDetails.add(rs.getString("FilmName"));

            }
            rs.close();
            con.close();




        } catch (Exception e) {
            System.out.println("Error in the SQL class:" + e);
        }
    }
}
