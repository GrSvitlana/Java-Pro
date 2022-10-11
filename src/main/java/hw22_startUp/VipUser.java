package hw22_startUp;

public class VipUser extends User {
    private double subscriberVipFee;

    public VipUser(double subscriberVipFee, String country) {
        this.subscriberVipFee = subscriberVipFee;
        super.country = country;
    }

    @Override
    public Double getIncome() {
        return subscriberVipFee;
    }
}
