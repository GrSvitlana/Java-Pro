package hw22_startUp;

public abstract class User {
    private String login;
    private String email;
    public String country;

    public String getCountry() {
        return country;
    }

    public abstract Double getIncome();
}
