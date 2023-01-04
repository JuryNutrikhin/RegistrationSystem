import java.io.*;
import java.util.List;
import java.util.Set;

public class RegistrationSystem {
    private String fileName;
    Set<User> users;

    public String getFileName() {
        return fileName;
    }

    //.........................................................................
    // Конструктор считывает из файла и кладем в arrayList
    public RegistrationSystem(String fileName) {
        this.fileName = fileName;

        try (FileInputStream fis = new FileInputStream(getFileName());
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            users = (Set<User>) ois.readObject();

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //.......................................................................

    //public void saveData() – метод, который будет сохранять содержимое списка users в файл,
    // имя которого было передано в конструкторе.
    public void saveData() {
//        //Получение текущей даты
//        Date dateNow = new Date();
//        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd 'и время' hh:mm:ss a zzz");
//        String d = formatForDateNow.format(dateNow);

        try (FileOutputStream fos = new FileOutputStream(getFileName());
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(users);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //..........................................................................

    //public bool register(String nickname, String password) – принимает на вход логин с паролем.
    // Если уже существует юзер с таким именем, то возвращает false.
    // Иначе, создается новый пользователь с этими данными и кладётся в список и возвращается true.

    public boolean register(String nickname, String password) {
        boolean bool = false;
        for (User user : users) {
            if ((user.getNickName()).equals(nickname) && (user.getPassword()).equals(password)) {
               return   bool = true;
            }
        }
        return bool;
    }

    //..........................................................................

    //public User login(String nickname, String password) - принимает на вход какой-то логин и пароль.
    // Если существует юзер с такими данными, то возвращает его, иначе возвращает null.
    public User login(String nickname, String password){
        User loginUser=null;
        for (User user : users) {
            if ((user.getNickName()).equals(nickname) && (user.getPassword()).equals(password)) {
                return  loginUser= user;
            }
        }
        return loginUser;
    }
    //..........................................................................
    //..........................................................................


}
