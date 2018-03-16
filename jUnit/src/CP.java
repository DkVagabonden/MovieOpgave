/**
 * The CP(controlPanel) class displays the control panel for user and administration
 *
 * @author  Pair Programming(alle)
 * @version 1.0
 * @since   16-03-2018
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CP {

    Scanner sc = new Scanner(System.in);

    /**
     * The controlPanel method displays the information for creating a new movie
     * and saves the movie object to the database
     * @throws IOException Because of file used.
     * @throws ClassNotFoundException if the file is not found.
     */
     public void controlPanel () throws IOException, ClassNotFoundException {

         Movie shows = new Movie();
         Database db = new Database();
         Theater theater = new Theater();
         List<Movie> movies = db.LoadMovies();
         System.out.println("Show title: ");
         shows.setTitle(noInput(sc.nextLine()));
         theater.setMovieName(shows.getTitle());
         System.out.println("Show minimum age: ");
         shows.setAge(noInput(sc.nextLine()));
         System.out.println("Show description: ");
         shows.setDescription(noInput(sc.nextLine()));
         System.out.println("Input show instructor: ");
         shows.setInstructor(noInput(sc.nextLine()));
         System.out.println("Show Time: ");
         shows.setTime(noInput(sc.nextLine()));
         System.out.println("saveTheater(1) or saveTheater(2): ");
         shows.setTheater(noInput(sc.nextLine()));
         theater.setWhichTeater(Integer.parseInt(shows.getTheater()));
         System.out.println("To stop type exit");
         System.out.println("Input show actors: ");
         ArrayList<String> actors = new ArrayList<>();

         boolean doYouKnowDaWae = true;
         while(doYouKnowDaWae) {

             String input = sc.nextLine();
             if(input.equalsIgnoreCase("exit"))
             {
                 break;
             }
             else {
                 System.out.println("To stop type exit");
                 System.out.println("Input next actors: ");
                 actors.add(noInput(input));
             }
         }

         shows.setActors(actors);

         System.out.println("Movie Information:");
         System.out.println("Title: " +  shows.getTitle());
         System.out.println("Age: " + shows.getAge());
         System.out.println("Description: " + shows.getDescription());
         System.out.println("Instructor: " + shows.getInstructor());
         System.out.print("Actors: ");
         for (String names: actors) {
             System.out.print(names + ", ");
         }

         System.out.println("");
         System.out.println("Type 1 for save to database");
         System.out.println("Type 2 for cancel and go back");

         if(sc.nextInt() == 1)
         {  //System.out.println(shows);
             db.SaveMovie(shows);
             db.SaveTheaters(theater);
             Login.Login();
         }
         else if(sc.nextInt() == 2){
             Login.Login();
         }
     }

    /**
     * The noInput method happens if the user types something incorrect.
     * @param input This is typed input
     * @return a warning message or the typed input
     */
     public String noInput(String input){

         while(input.equalsIgnoreCase(""))
         {
             System.out.println("You need to type some input");
             input = sc.nextLine();
         }

         return input;
     }
}
