package regEx;
/*
1. Write a regular expression that determines whether a given line is a hex color identifier in HTML. Where #FFFFFF for white, #000000 for black, #FF0000 for red, etc.
- example of correct expressions: #FFFFFF, #FF3421, #00ff00.
- example of incorrect expressions: 232323, f#fddee, #fd2.

2. Check if the password is strong. A password is considered strong if it consists of 8 or more characters. Where a character can be an English letter, a number and an underscore character.
- Example of correct expressions: C00l_Pass, SupperPas1.
- example of incorrect expressions: C00l.
 */

public class Main {
    public static void main(String[] args) {
        String[] array = {"#FFFFFF", "#FF3421", "#00ff00", "232323", "f#fddee", "#fd2"};
        String regExp = "^#[\\da-fA-F]{6}$";
        for (String s : array) {
            System.out.println(s + " is " + s.matches(regExp));
        }

        String[] array2 = {"C00l_Pass", "SupperPas1", "C00l", "12345678"};
        String regExp2 = "^[\\da-zA-Z_]{8,}$";
        for (String s : array2) {
            System.out.println(s + " is " + s.matches(regExp2));
        }
    }
}
