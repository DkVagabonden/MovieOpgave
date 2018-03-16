/**
 * The main class is the one that starts the program
 *
 * @author  Pair Programming(alle)
 * @version 1.0
 * @since   16-03-2018
 */

import java.io.IOException;

public class Main {

    /**
     * The main method starts the program.
     * @param args Standard for main method
     * @throws IOException Because of file used.
     * @throws ClassNotFoundException if the file is not found.
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
            Login login = new Login();
            User user = new User();
            user.setPassword("p");
            user.setType("Admin");
            user.setUserName("Patrick");

            login.Login();

    }
}
