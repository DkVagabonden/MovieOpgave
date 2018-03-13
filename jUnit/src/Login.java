import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Login {
    public static int lastnumber = 0;

    public static void userlogin() throws IOException, ClassNotFoundException {
        Scanner l = new Scanner(System.in);
        Database db = new Database();
        User activeUser = null;

        System.out.println("Type in your username");
        String username = l.nextLine();

        for (User user : db.LoadUsers()){
            if (username.equals(user.getUserName())){
                activeUser = user;
                break;
            }
        }
        if (activeUser != null){

            System.out.println("Type in your password:");
            String password = l.nextLine();

            if (password.equals(activeUser.getPassword())){
                System.out.println("Access granted");
                String type = activeUser.getType();
                System.out.println("You are a " + type);
                CP cp = new CP();
                cp.controlPanel();
            } else {
                System.out.println("Wrong password. Try again");
                userlogin();
            }
        } else {
            System.out.println("Wrong username. Try again");
            userlogin();
        }
    }

    public static void Login() throws IOException, ClassNotFoundException{


        System.out.println("\nAre you customer(1) or some kind of manager?(2)");
        Scanner l = new Scanner(System.in);
        String choice = l.nextLine();
        if(choice.equals("1")){
            System.out.print("Type in your username: ");
            String username = l.nextLine();
            run(username);
            Database db = new Database();
            List<Movie> movies = db.LoadMovies();
            int x;

            for(x = 0; x < movies.size(); x++){

                System.out.println(x+1 + ". Movie -> " + movies.get(x));

            }
            System.out.print("Which movie would you like to watch?: ");
            String answer = l.nextLine();
            int answer1 = Integer.parseInt(answer)-1;
            Movie movie = movies.get(answer1);
            BS.seatMenu(username, movie, answer1);
        }else if(choice.equals("2")){
            userlogin();
        }else{
            System.out.println("Please type in a number between 1 and 2");
            Login();
        }
    }
    public static void run(String user){
        System.out.println(ConsoleColors.YELLOW + "*    *   *     *       *       *       *" + ConsoleColors.RESET);
        System.out.print(
                ConsoleColors.RED + "W" +
                        ConsoleColors.YELLOW + "e" +
                        ConsoleColors.GREEN + "l" +
                        ConsoleColors.BLUE +  "c" +
                        ConsoleColors.PURPLE +  "o" +
                        ConsoleColors.RED + "m" +
                        ConsoleColors.CYAN + "e" +
                        " ");
        randomColors(user);
        System.out.println("");
        System.out.println(ConsoleColors.YELLOW + "*    *   *     *       *       *       *" + ConsoleColors.RESET);
    }
    public static void randomColors(String input){

        for(int i = 0; i<input.length(); i++)
        {
            Random rand = new Random();
            int  n = rand.nextInt(4) + 1;

            while(n == lastnumber)
            {
                n = rand.nextInt(4) + 1;
            }

            if(n == 1 && lastnumber != 1)
            {
                System.out.print(ConsoleColors.RED + input.charAt(i) + ConsoleColors.RESET);
                lastnumber = n;
                continue;
            }

            if(n == 2 && lastnumber != 2) {
                System.out.print(ConsoleColors.YELLOW + input.charAt(i)+ ConsoleColors.RESET);
                lastnumber = n;
                continue;
            }
            if(n == 3 && lastnumber != 3)
            {
                System.out.print(ConsoleColors.GREEN + input.charAt(i)+ ConsoleColors.RESET);
                lastnumber = n;
                continue;
            }
            if(n == 4 && lastnumber != 4)
            {
                System.out.print(ConsoleColors.BLUE + input.charAt(i)+ ConsoleColors.RESET);
                lastnumber = n;
                continue;
            }
        }
    }
}
