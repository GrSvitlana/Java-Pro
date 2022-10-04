package java_practic_Sep23_ReportService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
public class CacheService {


    // создаем класс Key
    private static class Key {
        private String country;
        private String city;
        private String department;

        public Key(String country, String city, String department) {
            this.country = country;
            this.city = city;
            this.department = department;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Key)) return false;
            Key report = (Key) o;
            return Objects.equals(country, report.country) && Objects.equals(city, report.city) && Objects.equals(department, report.department);
        }

        @Override
        public int hashCode() {
            return Objects.hash(country, city, department);
        }
    }

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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Key)) return false;
            Key report = (Key) o;
            return Objects.equals(country, report.country) && Objects.equals(city, report.city) && Objects.equals(department, report.department);
        }

        @Override
        public int hashCode() {
            return Objects.hash(country, city, department);
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
    }
    public CacheService() {}

    // Создаем кеш мап
    private final Map<Key, Report> cache = new HashMap<>();

    public final Report getMapCashe(String country, String city, String department) {
        Key key = new Key(country, city, department);
        Report report = cache.get(key);

        if(report != null) {
            System.out.println("From cache " + report);
            return report;
        } else {
            BigDecimal[] sap = ReportService.salesAndProfit(country, city, department);
            Report newReport = new Report(country, city, department, sap);
            cache.put(key, newReport);
            System.out.println("Not from cache " + newReport);
            return report;
        }
    }
}