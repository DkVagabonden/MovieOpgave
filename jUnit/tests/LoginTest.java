import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static org.junit.Assert.*;

public class LoginTest {

    @Test
    public void login() {

    }

    @Test
    public void run() {

    }

    @Test
    public void randomColors() {
        String input = "Morten";
        assertEquals("Morten", input);
        assertEquals(6, input.length());
        int lastnumber = 0;
        assertEquals(0, lastnumber);

        for(int i = 0; i<input.length(); i++) {



            Random rand = new Random();
            int  n = rand.nextInt(4) + 1;

            while(n == lastnumber)
            {
                n = rand.nextInt(4) + 1;
            }

            if (n == 1 && lastnumber != 1) {
                assertEquals(1,n);
                System.out.print(ConsoleColors.RED + input.charAt(i) + ConsoleColors.RESET);
                lastnumber = n;
                continue;
            }

            if (n == 2 && lastnumber != 2) {
                assertEquals(2,n);
                System.out.print(ConsoleColors.YELLOW + input.charAt(i) + ConsoleColors.RESET);
                lastnumber = n;
                continue;
            }
            if (n == 3 && lastnumber != 3) {
                assertEquals(3,n);
                System.out.print(ConsoleColors.GREEN + input.charAt(i) + ConsoleColors.RESET);
                lastnumber = n;
                continue;
            }
            if (n == 4 && lastnumber != 4) {
                assertEquals(4,n);
                System.out.print(ConsoleColors.BLUE + input.charAt(i) + ConsoleColors.RESET);
                lastnumber = n;
                continue;
            }
        }
    }
}