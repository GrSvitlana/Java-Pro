package annotation;

import colors.ConsoleColors;

public class TestClass {

    public static void method_1 () {
        System.out.println(ConsoleColors.RED + "Method 1 run ..." + ConsoleColors.RESET);
    }

    @BeforeSuite
    public void before () {
        System.out.println(ConsoleColors.CYAN + "Before suite run ..." + ConsoleColors.RESET);
    }

    @Test(priority = 3)
    public void test_3 () {
        System.out.println(ConsoleColors.BLUE + "Test 3 run ..." + ConsoleColors.RESET);
    }

    @Test()
    public void test_default () {
        System.out.println(ConsoleColors.YELLOW + "Test default run ..." + ConsoleColors.RESET);
    }

    @Test(priority = 1)
    public void test_1 () {
        System.out.println(ConsoleColors.YELLOW + "Test 1 run ..." + ConsoleColors.RESET);
    }

    @Test(priority = 2)
    public void test_2 () {
        System.out.println(ConsoleColors.PURPLE + "Test 2 run ..." + ConsoleColors.RESET);
    }

    @AfterSuite
    public void after () {
        System.out.println(ConsoleColors.GREEN + "Afteer suite run ..." + ConsoleColors.RESET);
    }
}
