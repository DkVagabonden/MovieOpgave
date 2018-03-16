/**
 * The BS(BookingSystem) class lets people order tickets and seats for a new movie.
 * And display the booking and non booked seats and other useful information.
 *
 * @author  Pair Programming(alle)
 * @version 1.0
 * @since   16-03-2018
 */

import java.util.List;
import java.util.Scanner;

public class BS {
    //Global Varaiabler.
    public static int theaterRows1 = 25, theaterSeats1 = 16;
    public static int theaterRows2 = 20, theaterSeats2 = 12;

    public static Database db = new Database();
    public static Theater theater = new Theater();


    /**
     * The seatMenu method displays the seatMenu and
     * accepts the different options that the customer have.
     * @param name This is the customers name
     * @param movie  This is the movie object.
     * @param id This is the movie ID
     */
    public static void seatMenu(String name, Movie movie, int id){
        theater = loadTheater(id);

        String seats[][];
        if(Integer.parseInt(movie.getTheater()) == 1) {

            if(theater.getSeats() != null)
            {
                seats = theater.getSeats();
            }
            else {
                seats = new String[theaterRows1][theaterSeats1];
            }
        }
        else {
            if(theater.getSeats() != null){
                seats = theater.getSeats();
            }
            else {
                seats = new String[theaterRows2][theaterSeats2];
            }
        }

        Scanner sc = new Scanner(System.in);
        String input;
        menu(movie);
        do{
            System.out.print("-> ");
            input = sc.next();
            switch (input){
                case "1":
                    seatShower(seats);
                    break;
                case "2":
                    getSeatsMenu(seats, name, movie, id);
                    break;
                case "3":
                    int[] specSeats = findSeats(seats);
                    break;
                case "4":
                    System.out.println("Seat taken by: " + checkSeatOwner(seats));
                    break;
                case "5":
                    menu(movie);
                    break;
                case "exit":
                    return;
            }
        }while (!(input.equals("exit")));
    }

    /**
     * The menu just display the sout's for the menu.
     * used in seatMenu
     * @param movie  This is the movie object.
     */
    private static void menu(Movie movie){
        System.out.println("Booking Manager!");
        System.out.println("Movie: " + movie.getTitle());
        System.out.println("1. See seats");
        System.out.println("2. Reservate seats");
        System.out.println("3. Find name");
        System.out.println("4. Check seat");
        System.out.println("5. Print menu");
    }


    /**
     * The getSeatsMenu ask the customer for the seats they
     * want to book and sets the theater object information
     * @param name This is the customers name
     * @param movie  This is the movie object.
     * @param id This is the movie ID
     * @param seats This is the seats 2d Array.
     * @return  the booked seats object
     */
    public static String[][] getSeatsMenu(String[][] seats, String name, Movie movie, int id){
        Scanner sc = new Scanner(System.in);
        int row;
        do{
            System.out.print("what row do you want to sit in?(" + 1 + "-" + seats.length + ") ");
            row = sc.nextInt();
        }while(!(row <= seats.length) || row < 0);
        System.out.print("Which seat(s) do you want?");
        System.out.print("From: ");
        int seatStart = sc.nextInt();
        System.out.print("To: ");
        int seatEnd = sc.nextInt();

        System.out.println("Row: " + row + " seat " + seatStart + " to " + seatEnd + " was selected");
        System.out.println();
        theater.setMovieName(movie.getTitle());
        reservate(seats, seatStart, seatEnd, row, name, id);
        return seats;
    }

    /**
     * The seatShower ask for the Seats and show which
     * seats are booked and which are not.
     * @param seats This is the seats 2d Array.
     */
    public static void seatShower(String[][] seats){
        System.out.print("Seats:");
        for(int o = 0; o < seats[0].length; o++)
            System.out.printf("%3d",(o+1));

        System.out.println();
        for(int i = 0; i < seats.length; i++){
            System.out.printf("Row " + "%-3d", (i+1));
            for(int y = 0; y < seats[0].length; y++){
                if((seats[i][y]) == null)
                    System.out.print("[o]");
                else
                    System.out.print("[x]");
            }
            System.out.println();
        }
        System.out.println("Type 5 to show the menu again.");
    }

    /**
     * The reservate is the menu thats calculate the seats
     * the customer wanna book and call's the method that saves it in the database
     * @param name This is the customers name
     * @param id This is the movie ID
     * @param seats This is the seats 2d Array.
     * @param row This is the inputted row the customer wanna sit on
     * @param seatStart This is the first seat the customer wanna buy on inputted row
     * @param seatEnd This is the last seat the customer wanna buy on inputted row
     * @return The reservate seats object.
     */
    public static String[][] reservate(String[][] seats, int seatStart, int seatEnd, int row, String name, int id){
        if(checkAvailability(seats, row, seatStart, seatEnd)){
            for(int i = Math.min(seatEnd, seatStart)-1; i <= Math.max(seatEnd, seatStart)-1; i++)
                seats[row-1][i] = name;
                theater.setSeats(seats);
                saveTheater(theater);
        }else
            System.out.println("The selected seats isn't available. No changes has been made!");
        return seats;
    }

    /**
     * The checkAvailability method checks if the seats is available or not.
     * @param seats This is the seats 2d Array.
     * @param row This is the inputted row the customer wanna sit on
     * @param seatStart This is the first seat the customer wanna buy on inputted row
     * @param seatEnd This is the last seat the customer wanna buy on inputted row
     * @return a boolean if those seats are available or not.
     */
    public static boolean checkAvailability(String[][] seats, int row, int seatStart, int seatEnd){
        boolean avail = true;
        for(int i = Math.min(seatEnd, seatStart)-1; i <= Math.max(seatEnd, seatStart)-1; i++){
            if(seats[row-1][i] != null){
                System.out.println("Seat " + (i+1) + " in row " + row + " is not available!");
                avail = false;
            }
        }
        return avail;
    }

    /**
     * The checkSeatOwner ask for the specific seat information
     * and display who reservated those seats.
     * @param seats This is the seats 2d Array.
     * @return The reservated seats -1 because of array starts at 0
     */
    public static String checkSeatOwner(String[][] seats){
        int row = 0, seat = 0;
        Scanner sc = new Scanner(System.in);
        do{
            try{
                System.out.print("Row: ");
                row = sc.nextInt();
                System.out.print("Seat: ");
                seat = sc.nextInt();
            }catch(NumberFormatException e){
                //System.out.println(e);
            }
        }while((!(row <= seats.length) || row < 0) || (!(seat <= seats[row].length || seat < 0)));
        return seats[row-1][seat-1];
    }

    /**
     * The findSeats finds which seats is reservated to that customer
     * @param seats This is the seats 2d Array.
     * @return an int array with the seat start and end.
     */
    public static int[] findSeats(String[][] seats){
        Scanner sc = new Scanner(System.in);
        System.out.print("Name to find seats of: ");
        String name = sc.next();
        int[] seatss = new int[3];//seat start, seat end and row
        seatss[0] = -1;
        for(int i = 0; i < seats.length; i++){
            for(int u = 0; u < seats[i].length;u++){
                try{
                    if(seats[i][u].equals(name)){
                        seatss[2] = i+1;
                        if(seatss[0]!=-1)
                            seatss[1] = u+1;
                        else
                            seatss[0] = u+1;
                    }
                }catch (NullPointerException ignored){}
            }
        }
        System.out.println("Seats in the name of " + name + " was reservated to row " + seatss[2] + " with the seats " + seatss[0] + "-" + seatss[1]);
        return seatss;
    }
    /**
     * The loadTheater loads the theater specific object from the database
     * @param showId This is the movies ID
     * @return the specific theater object
     */
    public static Theater loadTheater(int showId){
        List<Theater> theaters = db.LoadTheaters();
        return theaters.get(showId);
    }
    /**
     * The loadTheater saves the theater specific object to the database
     * @param theater This is the theater object
     */
    public static void saveTheater(Theater theater){

        db.SaveTheaters(theater);
    }
}
