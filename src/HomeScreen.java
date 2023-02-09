import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class HomeScreen {
    public static Scanner input = new Scanner(System.in);

    public static void HomeScreen() {
        System.out.println("1 - View available films \n2 - View account details");
        String response = input.next();

        if (response.equals("1")||response.equals("View available films")) {
            ViewFilms();
        } else if (response.equals("2")||response.equals("View account details")) {
            ViewAccountDetails();
        } else {
            System.out.println("Invalid option, returning to home screen.");
            HomeScreen();
        }

    }

    public static void ViewFilms() {
        SQLHandling.SQLViewFilms();

        System.out.println("Type the film name you'd like to book a viewing for, or type 'r' to return to the home screen.");
        String response = input.next();



        if (response.equals("r")) {
            HomeScreen();
        } else if (SQLHandling.FilmDetails.contains(response)) {
            Booking();
        }
    }

    public static void ViewAccountDetails() {
        SQLHandling.SQLViewAccountDetails();
    }

    public static void Booking(){
        System.out.println("For what date would you like to book this film for viewing?");
        String DateForViewing = input.next();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate Date = LocalDate.parse(DateForViewing, formatter);

        
    }
}
