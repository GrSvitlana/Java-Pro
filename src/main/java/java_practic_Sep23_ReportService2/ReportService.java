package java_practic_Sep23_ReportService2;

import java.math.BigDecimal;
// The simulator of the report service

public class ReportService {

    public static BigDecimal[] salesAndProfit(String country, String city, String department) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        } finally {
            return new BigDecimal[]{BigDecimal.valueOf((1. + Math.random() * 0.3) * 56765478.), BigDecimal.valueOf((1. + Math.random() * 0.3) * 159878.)};
        }
    }
}
