package java_practic_Sep23_ReportService2;

import java_practic_Sep23_ReportService.ReportService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CacheService {
    static class Key {
        String country;
        String city;
        String department;

        public Key(String country, String city, String department) {
            this.country = country;
            this.city = city;
            this.department = department;
        }
    }
    private final Map<String, BigDecimal[]> salesAndProfitCache = new HashMap<>();

    public BigDecimal[] getCache(String country, String city, String department) {
        String key = country + department + city;
        if (salesAndProfitCache.containsKey(key)) {
            return salesAndProfitCache.get(key);
        }
        BigDecimal[] sap = ReportService.salesAndProfit(country, city, department);
        salesAndProfitCache.put(key, sap);
        return sap;
    }
}