package java_practic_Sep23_ReportService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CacheService2 {

    // создаем класс Report
    private static class Report {
        private String country;
        private String city;
        private String department;
        private BigDecimal[] sap;

        public Report(String country, String city, String department, BigDecimal[] sap) {
            this.country = country;
            this.city = city;
            this.department = department;
            this.sap = sap;
        }

        @Override
        public String toString() {
            return "Report{" +
                    "country='" + country + '\'' +
                    ", city='" + city + '\'' +
                    ", department='" + department + '\'' +
                    ", sap=" + Arrays.toString(sap) +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Report)) return false;
            Report report = (Report) o;
            return Objects.equals(country, report.country) && Objects.equals(city, report.city) && Objects.equals(department, report.department);
        }

        @Override
        public int hashCode() {
            return Objects.hash(country, city, department);
        }
    }
    public CacheService2() {}

    // Создаем кеш мап
    private final Map<String, Map<String, Map<String, Report>>> cache = new HashMap<>();

    public final Report getMapCache(String country, String city, String department) {

        // Получаем данные если они есть в кеше
        Map<String, Map<String, Report>> countryCache = cache.get(country);
        if(countryCache != null) {
            Map<String, Report> cityCache = countryCache.get(city);
            if(cityCache != null) {
                Report report = cityCache.get(department);
                if(report != null) {
                    System.out.println("From cache " + report);
                    return report;
                }
            }
        }

        // Получаем данные если их в кеше нет
        BigDecimal[] sap = ReportService.salesAndProfit(country, city, department);
        Report report = new Report(country, city, department, sap);
        cache.putIfAbsent(country, new HashMap<>()); // создаем только если нет
        cache.get(country).putIfAbsent(city, new HashMap<>());
        cache.get(country).get(city).put(department, report);
        System.out.println("Not from cache " + report);
        return report;
    }
}