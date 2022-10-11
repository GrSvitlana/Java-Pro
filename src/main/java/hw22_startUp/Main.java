package hw22_startUp;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        SimpleUser simpleUser1 = new SimpleUser(15, 5, "DE");
        SimpleUser simpleUser2 = new SimpleUser(5, 5, "GB");
        SimpleUser simpleUser3 = new SimpleUser(5, 15, "IT");

        PremiumUser premiumUser1 = new PremiumUser(25, 10, "DE");
        PremiumUser premiumUser2 = new PremiumUser(21, 12, "IT");
        PremiumUser premiumUser3 = new PremiumUser(25, 11, "UA");

        VipUser vipUser1 = new VipUser(50, "DE");
        VipUser vipUser2 = new VipUser(50, "UA");
        VipUser vipUser3 = new VipUser(50, "GB");

        List<User> users = new ArrayList<>();
        Collections.addAll(users, simpleUser1, simpleUser2, simpleUser3, premiumUser1, premiumUser2, premiumUser3, vipUser1, vipUser2, vipUser3);
        System.out.println(getIncome(users));
        System.out.println(getIncome(users, "DE"));
    }

    public static Double getIncome(List<User> users) {
        double result = 0;
        for (User user : users) {
            result += user.getIncome();
        }
        return result;
    }

    public static double getIncome(List<User> users, String country) {
        return users.stream()
                .filter(user -> user.getCountry().equals(country))
                .mapToDouble(User::getIncome).sum();
    }
}
