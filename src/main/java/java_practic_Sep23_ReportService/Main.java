package java_practic_Sep23_ReportService;
/*
First level: Представим у нас есть некоторый сервис (ReportService), который возвращает статистические финансывые отчеты о филиалах вида (параметр - страна)
Report
Страна филиала,
Сумма продаж за год,
Сумма прибыли за год,
Но оказалось, что построенние данного отчета занимает очень много времени и вас заказчик попросил реализовать сервис кеширования (CacheService) с помощью HashMap,
который по стране филиала либо запрашивает данные у ReportService (если в кеше данных еще нет, а потом сохранает их в кеш), либо берет данные из кеша сразу (если они там уже сохранены).
Сам сервис отчета (ReportService) реализовывать полностью не нужно, можно просто возвращать некоторые случайные данные каждый раз (например, используя Math.random).
Важно реализовать именно сервис кеширования (CacheService)
Second level: То же самое, что в level 1, но в отчет добавить город и департамент (они же будут параметрами при запросе у CacheService и ReportService),
поэтому потребуется сделать кеширование с помощью дополнительного класса (не забудьте про equals и hashcod) или вложенных HashMap.
В случае, проблем с реализацией можно посмотреть то что мы делали на уроке код StreetService (https://github.com/tel-ran-de/tasks31m/blob/main/javapractic23092022/src/main/java/com/github/telran_de/StreetService.java).
 */

public class Main {
    public static CacheService cacheService = new CacheService();
    public static void main(String[] args) throws InterruptedException {

        cacheService.getMapCashe("Belgium", "Bruegge","Brue");
        cacheService.getMapCashe("Belgium", "Bruegge","Brue");
        cacheService.getMapCashe("Italy", "Venedig", "Ven");
        cacheService.getMapCashe("Italy", "Rom", "Rim");
        cacheService.getMapCashe("Belgium", "Bruegge","Brue");
        cacheService.getMapCashe("Italy", "Venedig", "Ven");
        cacheService.getMapCashe("Finland", "Helsinki", "Chesr");
        cacheService.getMapCashe("United Kingdom", "Manchester","Chester");
        cacheService.getMapCashe("Belgium", "Bruegge", "Brue");
        cacheService.getMapCashe("Austria", "Linz","Li");
        cacheService.getMapCashe("United Kingdom", "Manchester","Chester");
        cacheService.getMapCashe("Italy", "Rom", "Rim");
        cacheService.getMapCashe("Norway", "Oslo", "Oslo");
        cacheService.getMapCashe("Azerbaijan", "Baku","Bak");
        cacheService.getMapCashe("Belgium", "Bruegge","Brue");
        cacheService.getMapCashe("Norway", "Bergen", "Be");
        cacheService.getMapCashe("Belgium", "Bruegge","Brue");
        cacheService.getMapCashe("Finland", "Helsinki", "Chesr");
        cacheService.getMapCashe("United Kingdom", "Manchester","Chester");
        cacheService.getMapCashe("Italy", "Venedig", "Ven");
    }
}
