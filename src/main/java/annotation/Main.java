package annotation;
/*
Create a class that can perform "tests", the tests being classes with sets of methods with @Test annotations.
To do this, it must have a static method start(), to which either an object of type Class_1 or a class name is passed as a parameter.
From the "test class" a method with @BeforeSuite annotation must be run first, followed by methods with @Test annotations,
and after all the tests are finished - the method with @AfterSuite annotation. Priorities (int numbers from 1 to 10) must also be added to each test,
according to which the order of execution will be chosen. If the priority is the same, the order does not matter. Methods with annotations
@BeforeSuite and @AfterSuite must be present in a single instance, otherwise a RuntimeException must be thrown when starting "testing".
Note: this homework has nothing to do with the topic of testing through JUnit and using this library, that is, the project is written from scratch.
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final int MIN_PRIORITY = 1;
    public static final int MAX_PRIORITY = 10;

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        startRun(TestClass.class);
    }

    public static void startRun(Class c) throws InvocationTargetException {
        Method[] methods = c.getDeclaredMethods();
        List<Method> list = new ArrayList<Method>();

        // making a list of methods with annotations
        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)) {
                int priority = m.getAnnotation(Test.class).priority();
                if (priority < MIN_PRIORITY || priority > MAX_PRIORITY)
                    throw new RuntimeException("Priority exception");
                list.add(m);
            }
        }

        int last = list.size() - 1;

        // sorting methods
        list.sort((o1, o2) -> o1.getAnnotation(Test.class).priority() - o2.getAnnotation(Test.class).priority());

        // search for @BeforeSuite & @AfterSuite
        // adding @BeforeSuite to the first position
        // adding @AfterSuite to the last position
        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                if (list.get(0).isAnnotationPresent(BeforeSuite.class))
                    throw new RuntimeException("@BeforeSuite already is present on the first position");
                list.add(0, m);
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                if (list.get(last).isAnnotationPresent(AfterSuite.class))
                    throw new RuntimeException("@AfterSuite already is present on the last position");
                list.add(m);
            }
        }

        Object obj = null;
        try {
            obj = c.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Method m : list) {
            //System.out.println(c.getSimpleName());
            System.out.println(c.getName());
            try {
                m.invoke(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
