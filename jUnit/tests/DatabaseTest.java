import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    @Test
    public void loadsave_test()throws Exception{
        Database db = new Database();
        ArrayList<String> actors = new ArrayList<String>();
        actors.add("Michael Jordan");
        actors.add("Snurre Snup");
        // String title, String instructor, int time, ArrayList<String> actors, int age, int theater
        Movie movie = new Movie("Space Jam", "x", "19451603","Der var engang", actors, 12, 1 );


        db.oos.writeObject(movie);

        Movie  movietest = (Movie) db.ois.readObject();
        db.oos.close();

        assertEquals(12, movietest.getAge());





    }


}
