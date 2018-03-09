import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Database{

    // (String title, String instructor, int time, ArrayList<String> actors, int age, int theater


    List<Manager> managers;
    List<Movie> movies;


    public Database()  {

    managers = new ArrayList<Manager>();
    movies = new ArrayList<Movie>();
   LoadMovies();



    }

    public void SaveMovie(Movie movie) {

        try {
            FileOutputStream out = new FileOutputStream("database.dat");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            movies.add(movie);
            oos.writeObject(movies);
            oos.close();
            out.close();
        } catch(Exception e){

        }
    }



    public List<Movie> LoadMovies() {

        try {
            FileInputStream in = new FileInputStream("database.dat");
            ObjectInputStream ois = new ObjectInputStream(in);
           movies = (ArrayList<Movie>) ois.readObject();
            in.close();
            ois.close();
        } catch (Exception e) {
        }

        return movies;
    }



}

