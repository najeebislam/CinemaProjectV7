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

            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");

            //Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation);

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


    public static void SQLBooking(String FilmName,String Screen,String Date) {
        String DatabaseLocation = System.getProperty("user.dir")+"\\CourseworkDatabase.accdb";

        try {

            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");

            //Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation);

            //Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT FilmName FROM FilmDetails WHERE FilmName = '" + FilmName + "'");
            //System.out.println(FilmName);
            rs.next();
            String filmNameValue = rs.getString(1);


            //int ScreenNumber = Integer.parseInt(Screen);
            rs = stmt.executeQuery("SELECT ScreenID FROM ScreenDetails WHERE ScreenID = '" + Screen + "'");
            //System.out.println(Screen);
            rs.next();
            int screenIDValue = rs.getInt(1);



            String SQLLoginUsername = LoginRegister.LoginUsername;
            rs = stmt.executeQuery("SELECT UserID FROM UserDetails WHERE Username = '" + SQLLoginUsername + "'");
            //System.out.println(SQLLoginUsername);
            rs.next();
            int UserIDValue = rs.getInt(1);







            stmt.execute("INSERT INTO BookingDetails (FilmName, ScreenID, UserID, BookingDate) VALUES ('"+filmNameValue+"', '"+ screenIDValue+"', '"+UserIDValue+"','"+ Date+"')");


            con.close();




        } catch (Exception e) {
            System.out.println("Error in the SQL class:" + e);
        }

    }

    public static ArrayList<String> ScreenDetails = new ArrayList<>();
    public static void SQLDisplayScreens() {
        String DatabaseLocation = System.getProperty("user.dir")+"\\CourseworkDatabase.accdb";
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");

            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "SELECT * FROM ScreenDetails";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next())   {
                System.out.println("Screen Number: " + rs.getString("ScreenNumber"));
                System.out.println("Seat Capacity: " + rs.getString("SeatCapacity"));
                System.out.println("Screen Type: " + rs.getString("ScreenType"));
                System.out.println("----------------------------------------------------------------------------------------");
                ScreenDetails.add(rs.getString("ScreenNumber"));

            }
            rs.close();
            con.close();




        } catch (Exception e) {
            System.out.println("Error in the SQL class:" + e);
        }
    }
}
