import com.sun.source.tree.LambdaExpressionTree;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class HomeScreen {
    public static Scanner input = new Scanner(System.in);
    public static String Filmresponse;


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
        Filmresponse = input.next();



        if (Filmresponse.equals("r")) {
            HomeScreen();
        } else if (SQLHandling.FilmDetails.contains(Filmresponse)) {
            Booking();

        }
    }

    public static void ViewAccountDetails() {
        SQLHandling.SQLViewAccountDetails();
    }

    public static void Booking(){



        SQLHandling.SQLDisplayScreens();

        System.out.println("What screen number would you like to book?");
        String Screenresponse = input.next();

        if (!SQLHandling.ScreenDetails.contains(Screenresponse)) {
            System.out.println("That is not a valid screen, please try again.");
            Booking();
        }

        System.out.println("Would you like to order food and drinks?");
        String FoodandDrinksResponse = input.next();

        if (FoodandDrinksResponse.equals("yes")||FoodandDrinksResponse.equals("y")) {
            Order();
        }


        System.out.println("For what date would you like to book this film for viewing? (yyyy-MM-dd)");
        String DateForViewing = input.next();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate Date = LocalDate.parse(DateForViewing, formatter);

        SQLHandling.SQLBooking(Filmresponse,Screenresponse,DateForViewing);

        
    }

    public static void Order(){
        System.out.println("boo");
    }
}
