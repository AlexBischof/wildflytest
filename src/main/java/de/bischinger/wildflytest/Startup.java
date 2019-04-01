package de.bischinger.wildflytest;

import java.util.stream.IntStream;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author Alexander Bischof, BMW
 */
@Singleton
@javax.ejb.Startup
public class Startup {

    // @Inject
    // HelloWorld helloWorld;

    @Inject
    HelloWorld2 helloWorld2;

    @Resource(lookup = "java:jboss/ee/concurrency/executor/cobol")
    ManagedExecutorService managedExecutorService;

    @Schedule(second = "*/10", minute = "*", hour = "*", persistent = false)
    @PostConstruct
    public void hello() throws NamingException {

        // Variante mit managedExecutorService
        //IntStream.range(0, 2).forEach(i -> managedExecutorService.submit(() ->helloWorld2.doit()));

        // Variante mit Pool
        InitialContext ic = new InitialContext();
        IntStream.range(0, 6).boxed() //
                .parallel() //
                .map(i -> lookup(ic))//
                .forEach(HelloWorld::hello);

    }

    private HelloWorld lookup(final InitialContext ic) {
        try {
            return (HelloWorld) ic
                    .lookup("java:global/wildflytest-1.0-SNAPSHOT/HelloWorld!de.bischinger.wildflytest.HelloWorld");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
