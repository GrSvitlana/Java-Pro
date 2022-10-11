package hw22_startUp;

public class PremiumUser extends User {
    private double subscriberPremiumFee;
    private double incomeFromAdditinalService;

    public PremiumUser(double subscriberPremiumFee, double incomeFromAdditinalService, String country) {
        this.subscriberPremiumFee = subscriberPremiumFee;
        this.incomeFromAdditinalService = incomeFromAdditinalService;
        super.country = country;
    }

    @Override
    public Double getIncome() {
        return subscriberPremiumFee + incomeFromAdditinalService;
    }
}
