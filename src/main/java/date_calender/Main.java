package date_calender;
/*
1. Create an object of class LocalDate, specifying your date of birth.
a) Display the day of the week, day of the year, month, year on the console.
b) Create an object of class LocalDate representing the current time.
c) Compare it to your birthday using the isAfter(), isBefore() methods.

2. Print out the schedule of holidays for the current year using formatting.
 */

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        LocalDate birthday = LocalDate.of(1991, Month.SEPTEMBER, 4);
        System.out.printf("The day of the week is %s.\nThe day of the year is %s\n" +
                "The month is %s\nThe year is %s\n",
                birthday.getDayOfWeek(), birthday.getDayOfYear(),
                birthday.getMonth(), birthday.getYear());

        LocalDate today = LocalDate.now();
        System.out.println(today.isAfter(birthday));
        System.out.println(today.isBefore(birthday));

        Map<String, String> holidays = new HashMap<>();
        holidays.put("New Year's Day", String.valueOf(LocalDate.of(2023, Month.JANUARY, 1)));
        holidays.put("Womens' Day", String.valueOf(LocalDate.of(2023, Month.MARCH, 8)));
        holidays.put("Easter", String.valueOf(LocalDate.of(2023, Month.APRIL, 9)));
        holidays.put("May Day", String.valueOf(LocalDate.of(2023, Month.MAY, 1)));
        holidays.put("Ascension", String.valueOf(LocalDate.of(2023, Month.MAY, 18)));
        holidays.put("Whit Monday", String.valueOf(LocalDate.of(2023, Month.MAY, 29)));
        holidays.put("German Unity Day", String.valueOf(LocalDate.of(2023, Month.OCTOBER, 3)));
        holidays.put("Christmas Day", String.valueOf(LocalDate.of(2023, Month.DECEMBER, 25)));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (Map.Entry<String, String> entry : holidays.entrySet()) {
            System.out.printf("%s - %s\n", entry.getKey(), LocalDate.parse(entry.getValue(), formatter));
        }
    }
}
