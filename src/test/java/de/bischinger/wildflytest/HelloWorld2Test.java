package de.bischinger.wildflytest;

import static java.util.concurrent.Executors.newFixedThreadPool;

import javax.enterprise.concurrent.ManagedExecutorService;

/**
 * @author Alexander Bischof, BMW
 */
public class HelloWorld2Test {
    public static void main(String[] args) {

        final HelloWorld2 helloWorld2 = new HelloWorld2();

        //helloWorld2.managedExecutorService =  newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            helloWorld2.doit();
        }
    }
}