package stringBuilder;
/*
1. Given two numbers, for example 3 and 56, you need to make the following lines:
3 + 56 = 59
3 - 56 = -53
3 * 56 = 168.
Use the StringBuilder.append() method.

2. Replace the "=" character with the word "equal". Use the StringBuilder.insert(), StringBuilder.deleteCharAt() methods.

3. Replace the "=" character with the word "equal". Use StringBuilder.replace() methods.
 */

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int a = 3;
        int b = 56;
        char[] op = {'+', '-', '*'};
        for (int i = 0; i < op.length; i++) {
            int result = op[i] == '+' ? a + b : op[i] == '-' ? a - b : a * b;
            System.out.println(stringBuilder(a, b, op[i], result));
        }

        System.out.println(replaseEqual_insert(stringBuilder(a, b, '+', a + b)));
        System.out.println(replaseEqual_replace(stringBuilder(a, b, '-', a - b)));
    }

    private static StringBuilder stringBuilder(int a, int b, char op, int result) {
        return new StringBuilder()
                .append(a)
                .append(" ")
                .append(op)
                .append(" ")
                .append(b)
                .append(" ")
                .append("=")
                .append(" ")
                .append(result);
    }

    private static StringBuilder replaseEqual_insert(StringBuilder stringBuilder) {
        int index = stringBuilder.indexOf("=");
        return stringBuilder.deleteCharAt(index).insert(index, "equal");
    }

    private static StringBuilder replaseEqual_replace(StringBuilder stringBuilder) {
        int index = stringBuilder.indexOf("=");
        return stringBuilder.replace(index, index + 1, "equal");
    }
}
