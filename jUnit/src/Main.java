import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try{
            Login login = new Login();
            User user = new User();
            user.setPassword("p");
            user.setType("Admin");
            user.setUserName("Patrick");

            login.Login();
        }catch(Exception e){

        }

    }
}
