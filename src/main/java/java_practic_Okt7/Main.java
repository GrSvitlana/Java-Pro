package java_practic_Okt7;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "Hello", "Java", "Spring");

        list.forEach(s -> System.out.println(s));

        Operationable<Integer> operation;
        operation = (x, y) -> x + y;
        Operationable<Double> operation2 = (a, b) -> b - a;
        Operationable<Integer> operation3 = (x, y) -> {
            for (int i = 0; i < 10; i++) {
                --y;
            }
            if (x + y > 0) {
                return x - y;
            } else {
                return 100;
            }
        };

        Operationable<Integer> operation4 = new Operationable<Integer>() {
            @Override
            public Integer calculate(Integer x, Integer y) {
                return x * y;
            }
        };

        int result = operation.calculate(12, 3);
        System.out.println(result);
        System.out.println(operation2.calculate(12.76, 15.05));
        System.out.println(operation3.calculate(22, 33));
        System.out.println(operation4.calculate(2, 3));
    }
}
