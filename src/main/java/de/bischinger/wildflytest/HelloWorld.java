package de.bischinger.wildflytest;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

import org.jboss.ejb3.annotation.Pool;

/**
 * @author Alexander Bischof, BMW
 */
@Stateless
@Pool(value = "cobol-max-pool")
public class HelloWorld {

    @PostConstruct
    public void hello() {
        try {
            Thread.sleep(1_000L);
            System.out.println("------------->Hello");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
