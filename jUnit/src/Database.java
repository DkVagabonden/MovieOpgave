import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Database{

    // (String title, String instructor, int time, ArrayList<String> actors, int age, int theater

    List<Movie> movies;
    List<Manager> managers;

    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("database.dat"));

    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("database.dat"));


    public Database() throws IOException {
        movies = new ArrayList<Movie>();
        managers = new ArrayList<Manager>();

    }

    public void SaveMovie(Movie movie) throws Exception{
        movies.add(movie);
        oos.writeObject(movies);
        oos.close();
    }

    public void SaveManager(Manager manager) throws Exception{
        managers.add(manager);
        oos.writeObject(managers);
        oos.close();
    }

    public List<Movie> LoadMovies() throws Exception{
        return (ArrayList<Movie>) ois.readObject();
    }

    public List<Manager> LoadManagers() throws Exception{
        return (ArrayList<Manager>) ois.readObject();
    }


}

