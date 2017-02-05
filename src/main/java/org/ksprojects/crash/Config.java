package org.ksprojects.crash;

import org.crsh.spring.SpringBootstrap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Kostiantyn Shchepanovskyi
 */
@Configuration
public class Config {

    @Bean
    public AtomicBoolean terminator() {
        return new AtomicBoolean();
    }

    @Bean
    public SpringBootstrap crashShellBootstrap() {
        SpringBootstrap bootstrap = new SpringBootstrap();
        bootstrap.setCmdMountPointConfig("classpath:/commands/;classpath:/crash/commands/base/");
//        bootstrap.setCmdMountPointConfig();
        Properties config = new Properties();
        config.setProperty("crash.ssh.port", "2000");
        config.setProperty("crash.vfs.refresh_period", "1");

        config.setProperty("crash.ssh.port", "2000");

        config.setProperty("crash.ssh.auth_timeout", "300000");
        config.setProperty("crash.ssh.idle_timeout", "300000");

        config.setProperty("crash.telnet.port", "5000");

//        config.setProperty("crash.auth", "simple");
//        config.setProperty("crash.auth.simple.username", "admin");
//        config.setProperty("crash.auth.simple.password", "admin");

        config.setProperty("crash.auth", "jaas");
        config.setProperty("crash.auth.jaas.domain", "pam-login");

        bootstrap.setConfig(config);
        return bootstrap;
    }
}
