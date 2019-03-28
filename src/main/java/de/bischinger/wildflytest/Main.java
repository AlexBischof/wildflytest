package de.bischinger.wildflytest;

/**
 * @author Alexander Bischof
 */
public class Main {
    public static void main(String[] args) {
        String hello = "hello";

        Calculator impl1 = (a, b) -> a + b;
        Calculator impl2 = (a, b) -> a + b + 1;

        System.out.println(Calculator.IMPL1.add(1, 2));

        MyPredicate pred1 = t -> false;
        MyPredicate pred2 = t -> true;

        System.out.println(pred1.and(pred2).test("alex"));

        System.out.println(new CalculatorExecutor().execute((a, b) -> a * b, 1, 2));


    }

    @FunctionalInterface
    interface Calculator {

        Calculator IMPL1 = (a, b) -> a + b;
        Calculator IMPL2 = (a, b) -> a + b + 1;

        int add(int a, int b);
    }

    interface MyPredicate {

        boolean test(String t);

        default MyPredicate and(MyPredicate p) {
            // t = alex
            return t ->
                    //pred1.test("alex)
                    test(t) &&
                            // pred2.test("alex")
                            p.test(t);
        }

    }

    static class CalculatorExecutor {
        int execute(Calculator calculator, int a, int b) {
            return calculator.add(a, b);
        }
    }
}
