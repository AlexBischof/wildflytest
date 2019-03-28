package de.bischinger.wildflytest;

import javax.ejb.Stateless;

/**
 * @author Alexander Bischof, BMW
 */
@Stateless
public class HelloWorld2 {

    static int counter;

    public void doit() {
        try {
            Thread.sleep(1_000);
            System.out.println("------------->Hello2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
