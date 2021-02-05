package annotation;

import java.lang.reflect.Method;

public class WebbTestsRunner {

    public static void main(String[] args) {
        startTests();
    }

    private static void startTests() {
        Class testsClass = WebbTests.class;
        WebbTests mainObj = new WebbTests();
        Method[] methods = testsClass.getDeclaredMethods();

        printBeforeClass(methods, mainObj);

        for (Method method : methods) {
            String methodName = method.getName();
            if (method.isAnnotationPresent(WebbTest.class)) {
                WebbTest anno = method.getDeclaredAnnotation(WebbTest.class);
                printBeforeMethod(methods, mainObj);
                if (anno.online()) {
                    try {
                        method.invoke(mainObj, (Object) null);
                        System.out.println(methodName + " passed: " + anno.desc());
                    } catch (Exception e) {
                        System.out.println(methodName + " failed: " +
                                e.getMessage() + " " + anno.error());
                    }
                } else {
                    System.out.println(methodName + " skipped : offline case");
                }
                printAfterMethod(methods, mainObj);
            }
        }
        printAfterClass(methods, mainObj);
    }


    private static void printBeforeMethod(Method[] methods, WebbTests mainObj) {
        for (Method method1 : methods) {
            if (method1.isAnnotationPresent(WebbBeforeMethod.class)) {
                try {
                    method1.invoke(mainObj, (Object) null);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private static void printAfterMethod(Method[] methods, WebbTests mainObj) {
        for (Method method : methods) {
            if (method.isAnnotationPresent(WebbAfterMethod.class)) {
                try {
                    method.invoke(mainObj, (Object) null);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private static void printBeforeClass(Method[] methods, WebbTests mainObj) {
        for (Method method : methods) {
            if (method.isAnnotationPresent(WebbBeforeClass.class)) {
                try {
                    method.invoke(mainObj, (Object) null);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private static void printAfterClass(Method[] methods, WebbTests mainObj) {
        for (Method method : methods) {
            if (method.isAnnotationPresent(WebbAfterClass.class)) {
                try {
                    method.invoke(mainObj, (Object) null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}