import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class ShowsTest {

    @Test
    public void show() {


        Movie shows = new Movie();
        ArrayList<String> Arvid = new ArrayList<>();

        Arvid.add("Patrick Klubel");
        Arvid.add("Patrick Klubel");
        Arvid.add("Patrick Klubel");
        Arvid.add("Patrick Klubel");
        Arvid.add("Patrick Klubel");
        Arvid.add("Patrick Klubel");
        Arvid.add("Patrick Klubel");
        Arvid.add("Patrick Klubel");


        shows.setAge("15");
        shows.setTime(190);
        shows.setInstructor("Patrick Klæbel");
        shows.setDescription("Arvid spiser æble");


        assertEquals("15",shows.getAge());
        assertEquals(190, shows.getTime());
        assertEquals("Arvid spiser æble", shows.getDescription());
        assertEquals("Patrick Klæbel", shows.getInstructor());
        assertEquals("Patrick Klubel", Arvid.get(2));
        assertEquals(8, Arvid.size());

    }

}