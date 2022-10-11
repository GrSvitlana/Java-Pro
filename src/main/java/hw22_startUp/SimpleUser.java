package hw22_startUp;

public class SimpleUser extends User {
    private double incomeFromAdvertising;
    private double incomeFromAdditinalService;

    public SimpleUser(double incomeFromAdvertising, double incomeFromAdditinalService, String country) {
        this.incomeFromAdvertising = incomeFromAdvertising;
        this.incomeFromAdditinalService = incomeFromAdditinalService;
        super.country = country;
    }

    @Override
    public Double getIncome() {
        return incomeFromAdvertising + incomeFromAdditinalService;
    }
}
