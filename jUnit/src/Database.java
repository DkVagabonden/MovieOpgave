import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Database{

    // (String title, String instructor, int time, ArrayList<String> actors, int age, int theater


    List<Manager> managers;
    List<Movie> movies;
    List<Theater> theaters;
    List<User> users;


    public Database()  {

    managers = new ArrayList<Manager>();
    theaters = new ArrayList<>();
    movies = new ArrayList<Movie>();
    users = new ArrayList<>();
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

    public void SaveTheaters(Theater theater) {

        try {
            FileOutputStream out = new FileOutputStream("theaters.dat");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            List<Theater> random = LoadTheaters();
            System.out.println(random.size());
            if(random.size() != 0) {
                //theaters.remove(theater.getId());
                System.out.println(theater.getId());
                random.set(theater.getId(), theater);
                System.out.println("FASDASDASDASDASD");
                oos.writeObject(random);
            }
            else {
                theaters.add(theater);
                oos.writeObject(theaters);
                System.out.println("skal kun  kører");
            }
            System.out.println(theaters);
           // oos.writeObject(theaters);
            oos.close();
            out.close();
        } catch(Exception e){

        }
    }

    public List<Theater> LoadTheaters(){

        try {
            FileInputStream in = new FileInputStream("theaters.dat");
            ObjectInputStream ois = new ObjectInputStream(in);
            theaters = (ArrayList<Theater>) ois.readObject();
            in.close();
            ois.close();
        } catch (Exception e) {
        }

        return theaters;
    }

    public List<User> LoadUsers() {
        try {
            FileInputStream in = new FileInputStream("user_database.dat");
            ObjectInputStream ois = new ObjectInputStream(in);
            this.users = (ArrayList)ois.readObject();
            System.out.println();
            in.close();
            ois.close();
        } catch (Exception var3) {
            System.out.println(var3 + " Der gik noget galt");
        }
        return this.users;
    }

    public void SaveUser(User user) {
        try {
            FileOutputStream out = new FileOutputStream("user_database.dat");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            this.users.add(user);
            oos.writeObject(this.users);
            oos.close();
            out.close();
        } catch (Exception var4) {
            ;
        }

    }
}

