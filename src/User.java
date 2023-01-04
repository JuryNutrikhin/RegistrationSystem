import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private  String nickName;
    private String password;
    private Date registrationDate;

    public User(String nickName, String password, Date registrationDate) {
        this.nickName = nickName;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    public String getNickName() {
        return nickName;
    }

    public String getPassword() {
        return password;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }
}
