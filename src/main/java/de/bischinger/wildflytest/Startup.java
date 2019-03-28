package de.bischinger.wildflytest;

import java.util.stream.IntStream;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;

/**
 * @author Alexander Bischof, BMW
 */
@Singleton
@javax.ejb.Startup
public class Startup {

    @Inject
    HelloWorld helloWorld;

    @Inject
    HelloWorld2 helloWorld2;

    @Resource(lookup = "java:jboss/ee/concurrency/executor/cobol")
    ManagedExecutorService managedExecutorService;

    @Schedule(second = "*/1", minute = "*", hour = "*", persistent = false)
    @PostConstruct
    public void hello() {
       // IntStream.range(0, 2).forEach(i -> managedExecutorService.submit(() ->helloWorld2.doit()));
        helloWorld.hello();

    }
}
