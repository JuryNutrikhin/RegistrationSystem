import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class W {
    public static void main(String[] args) {
//        RegistrationSystem registrationSystem = new RegistrationSystem("user.bin");
        Date rD = new Date();
//        registrationSystem.users.add(new User("Bob","1111",rD));
//        registrationSystem.saveData();
        Set<User> users= new HashSet<>();
        users.add(new User("Bob","1111",rD));

        try (FileOutputStream fos = new FileOutputStream("user.bin");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(users);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
