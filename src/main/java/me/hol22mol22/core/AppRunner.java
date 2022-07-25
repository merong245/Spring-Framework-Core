package me.hol22mol22.core;

import me.hol22mol22.core.MyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext ctx;
    @Autowired
    ApplicationEventPublisher publisher;

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        publisher.publishEvent(new MyEvent(this, 100));

        // 접두어 사용시 ClassPathResource
        Resource resource = resourceLoader.getResource("classpath:test.txt");
        System.out.println(resource.exists());
        System.out.println(resource.getDescription());
        System.out.println(Files.readString(Path.of(resource.getURI())));
        System.out.println(resourceLoader.getClass());
        System.out.println(resource.getClass());

        // 접두어 미사용시 ServletContextResource
        resource = resourceLoader.getResource("test.txt");
        System.out.println(resource.exists());
        System.out.println(resource.getClass());
    }

}
