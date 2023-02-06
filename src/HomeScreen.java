import java.util.Scanner;

public class HomeScreen {
    public static Scanner input = new Scanner(System.in);

    public static void HomeScreen() {
        System.out.println("1 - View available films \n2 - View account details");
        String response = input.next();

        if (response.equals("1")||response.equals("View available films")) {
            ViewFilms();
        }
    }

    public static void ViewFilms() {
        SQLHandling.SQLViewFilms();

        System.out.println("Type the film name you'd like to book a viewing for, or type 'r' to return to the home screen.");
        input.next();
        String response = input.nextLine();


        if (response.equals("r")) {
            HomeScreen();
        } else if (SQLHandling.FilmDetails.contains(response)) {
            Booking();
        }
    }

    public static void ViewAccountDetails() {

    }

    public static void Booking(){
        System.out.println("mo");
    }
}
