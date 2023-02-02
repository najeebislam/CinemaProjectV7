import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
public class LoginRegister {
    public static Scanner input = new Scanner(System.in);

    public static void LoginOrRegister() {
        try {

            System.out.println("1 - Login \n 2 - Register");
            String OptionsChoice = input.next();


            if (OptionsChoice.equals("Login")) {
                Login();
            } else if (OptionsChoice.equals("Register")) {
                Register();
            } else {
                System.out.println("Invalid Input! Type 'Login' or 'Register'");
                LoginOrRegister();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void Login() {
        SQLHandling.SQLLogin();
        System.out.println("Username: ");
        String LoginUsername = input.next();


        System.out.println("Password: ");
        String LoginPassword = input.next();

        if(SQLHandling.UserDetails.contains(LoginUsername.toString() +","+  LoginPassword.toString()))  {
            System.out.println("Login Successful!");
        }
        else {
            System.out.println("Incorrect Details, please try again");
            Login();
        }


    }


    public static void Register() {

        System.out.println("What will your username be?");
        String RegisterUsername = input.next();

        System.out.println("Choose a password:");
        String RegisterPassword = input.next();

        /*System.out.println("What is your date of birth?");
        String RegisterDOB = input.next();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate Date = LocalDate.parse(RegisterDOB, formatter);

        SQLHandling.SQLRegister(RegisterUsername, RegisterPassword);


        */

    }

}
