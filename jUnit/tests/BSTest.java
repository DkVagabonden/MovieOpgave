import org.junit.Test;

import static org.junit.Assert.*;

public class BSTest {

    @Test
    public void bookingSystem() {

        Boolean[][] seats = new Boolean[25][16];

        for(int i = 0; i <26; i++){
            for(int y = 0; i<6; y++)
            {
                seats[i][y] = false;
                System.out.println(i + "y: " +  y);
            }
        }

       assertEquals(false, seats[24][3]);
    }
}