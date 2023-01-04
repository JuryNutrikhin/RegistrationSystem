
import java.util.Date;
import java.util.Scanner;

/**
 * Задание
 * Вам предстоит сделать небольшую систему регистрации. Для этого вам понадобятся следующие классы:
 * User – класс «пользователь»
 * RegistrationSystem – класс «система»
 *
 * У пользователя должны быть следующие поля:
 * String nickname – имя пользователя
 * String password – пароль пользователя
 * Date registrationDate – дата, когда пользователь зарегистрировался
 * Система регистрации должна содержать в себе следующие поля:
 * String filename; - имя файла, в котором хранятся данные о пользователях.
 * List<User> users – список пользователей системы.
 * А также, следующие методы:
 * public User login(String nickname, String password)  - принимает на вход какой-то логин и пароль. Если существует юзер с такими данными, то возвращает его, иначе возвращает null.
 * public bool register(String nickname, String password) – принимает на вход логин с паролем. Если уже существует юзер с таким именем, то возвращает false. Иначе, создается новый пользователь с этими данными и кладётся в список и возвращается true.
 * public void saveData() – метод, который будет сохранять содержимое списка users в файл, имя которого было передано в конструкторе.
 * Система регистрации должна принимать в конструкторе имя файла, в котором лежат сериализованные пользователи, считывать пользователей из файла и класть в список users.
 *
 * Затем, в точке входа main реализуйте следующий функционал:
 * Должно быть 3 пункта меню. Авторизация, регистрация, выход из программы.
 * При успешной авторизации пользователя выведите на экран «Вы успешно авторизованы». Иначе «Неверный логин или пароль»
 * При успешной регистрации выведите на экран «Вы успешно зарегистрировались!». Иначе «Такой пользователь уже существует».
 *
 * В самом конце метода main обязательно вызывайте метод saveData, чтобы сохранялось состояние системы в файл!
 * Для сохранения объектов в файл используйте ObjectOutputStream, для считывания – ObjectInputStream.
 */

public class Main {
    public static void main(String[] args) {
        String nickName = "";
        String password = "";
        RegistrationSystem registrationSystem = new RegistrationSystem("user.bin");

        System.out.println("Выберите один из трёх  пунктов меню :");
        System.out.println();
        System.out.println("Авторизация - нажмите 1\n" +
                "Регистрация - нажмите 2\n" +
                "Выход из программы -нажмите 3\n");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        if (num == 1) {
            System.out.println("Введите логин:");
            nickName = scanner.next();

            System.out.println("Введите пароль :");
            password = scanner.next();

            if ((registrationSystem.login(nickName, password) != null)) {
                System.out.println(" «Вы успешно авторизованы». ");
            } else System.out.println("«Неверный логин или пароль»\n");

        } else if (num == 2) {
            System.out.println("Введите логин:");
            nickName = scanner.next();

            System.out.println("Введите пароль :");
            password = scanner.next();

            if (!(registrationSystem.register(nickName, password))) {

                //Получение текущей даты
                Date registrationDate = new Date();

                registrationSystem.users.add(new User(nickName, password, registrationDate));
               // registrationSystem.saveData();
                System.out.println("«Вы успешно зарегистрировались!».");
            }else System.out.println("«Такой пользователь уже существует».");
        }else {
            registrationSystem.saveData();
        }


    }

}