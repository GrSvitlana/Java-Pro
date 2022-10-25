package hw26_Okt23_Exceptions;
/*
Create a static method that takes three parameters: login, password and confirmPassword.
Login must contain only Latin letters, numbers and underscore.
The length of login must be less than 20 characters. If login doesn't meet these requirements, WrongLoginException must be thrown.
Password must contain only Latin letters, numbers and underscore character. Password must be less than 20 characters long.
Also password and confirmPassword must be equal. If password doesn't meet these requirements, a WrongPasswordException should be thrown.
WrongPasswordException and WrongLoginException are custom exception classes with two constructors - one by default,
The second accepts an exception message and passes it to the constructor of the Exception class.
Exceptions are handled inside method.
We use multi-catch block.
The method returns true if the values are true or false otherwise.
Translated with www.DeepL.com/Translator (free version)
 */

import java.util.Locale;

public class Main {
    private String login;
    private String password;
    private String confirmPassword;

    public static void main(String[] args) {
        System.out.println(validation("customer_", "12345678", "12345678"));
        System.out.println(validation("user_user_user_user_", "abcdefg", "abcdefg?"));
        System.out.println(validation("guest", "1234567", "abcdefg"));
    }

    public static boolean validation(String login, String password, String confirmPassword) {
        try {
            if (!stringCheck(login)) {
                throw new WrongLoginException();
            }
            if (!stringCheck(password)) {
                throw new WrongPasswordException();
            }
            if (!confirmPasswords(password, confirmPassword)) {
                throw new WrongPasswordException();
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static boolean stringCheck(String str) {
        if (str.length() >= 20) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isAlphabetic(c) && !Character.isDigit(c) && c != '_') {
                return false;
            }
        }
        return true;
    }

    private static boolean confirmPasswords(String s1, String s2) {
        if (!s1.equals(s2)) {
            return false;
        }
        return true;
    }

}
