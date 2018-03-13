
import java.io.Serializable;

public class User implements Serializable {
    private String userName;
    private String password;
    private String type;
    private static final long serialVersionUID = 1L;

    public User() {
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}