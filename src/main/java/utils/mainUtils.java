package utils;

import java.util.Scanner;

import at.favre.lib.crypto.bcrypt.BCrypt;
import models.UserCreation;

public class mainUtils {

    public static UserCreation createUser() {
        Scanner scanner = new Scanner(System.in);
        UserCreation userCreation = new UserCreation();

        while(true) {

            System.out.println("Enter your nickname: ");
            String nickname = scanner.nextLine();

            System.out.println("Enter your username: ");
            String user = scanner.nextLine();

            System.out.println("Enter your password: ");
            String password = scanner.nextLine();

            System.out.println("Enter your bio: ");
            String bio = scanner.nextLine();

            password = BCrypt.withDefaults().hashToString(12, password.toCharArray());

            userCreation.setNickname(nickname);
            userCreation.setUser(user);
            userCreation.setPassword(password);
            userCreation.setBio(bio);
            break;
        }

        return userCreation;
    }
    public static BCrypt.Result resolve(String hashedPassword) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your password for verify: ");
        String password = scanner.nextLine();

        return BCrypt.verifyer().verify(password.toCharArray(), hashedPassword);
    }
}
