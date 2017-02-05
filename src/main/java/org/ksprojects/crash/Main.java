package org.ksprojects.crash;

import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Kostiantyn Shchepanovskyi
 */
public class Main {

    public static void main(String[] args) throws Exception {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
        System.setProperty("java.security.auth.login.config",
                Main.class.getClassLoader().getResource("jaas.conf").toString());
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        AtomicBoolean terminator = context.getBean("terminator", AtomicBoolean.class);
        while (!terminator.get()) {
            Thread.sleep(100);
        }
    }
}
