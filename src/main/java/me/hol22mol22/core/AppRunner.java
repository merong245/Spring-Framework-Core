package me.hol22mol22.core;

import me.hol22mol22.core.event.EventService;
import me.hol22mol22.core.library.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

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

    @Autowired
    Validator validator;

    @Value("#{1+1}")
    int value;


    @Value("#{'hello ' + 'world'}" )
    String greeting;

    @Value("#{1 eq 1}")
    boolean trueOrFalse;

    @Value("${my.value}")
    int myValue;

    @Value("#{${my.value} eq 100}")
    boolean isMyValue100;

    @Value("#{sample.data}")
    int sampleData;


    // 스프링 AOP
    @Autowired
    EventService eventService;

    // null safety
    @Autowired
    LibraryService libraryService;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Event Publisher
        publisher.publishEvent(new MyEvent(this, 100, ""));

        // Resource
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


        // Validator
        MyEvent event = new MyEvent(this,-1, "");
        // 설정 Validator
        MyEventValidator eventValidator = new MyEventValidator();
        Errors errors = new BeanPropertyBindingResult(event, "event");

        eventValidator.validate(event,errors);

        System.out.println(errors.hasErrors());

        errors.getFieldErrors().forEach(e ->{
            System.out.println("=====error code ======");
            Arrays.stream(e.getCodes()).forEach(System.out::println);
            System.out.println(e.getDefaultMessage());
        });
        // 스프링 부트 제공 Validator

        validator.validate(event,errors);
        System.out.println(errors.hasErrors());

        errors.getFieldErrors().forEach(e ->{
            System.out.println("=====error code ======");
            Arrays.stream(e.getCodes()).forEach(System.out::println);
            System.out.println(e.getDefaultMessage());
        });
        System.out.println(validator.getClass());

        // SpEL
        System.out.println("============");
        System.out.println(value);
        System.out.println(greeting);
        System.out.println(trueOrFalse);
        System.out.println(myValue);
        System.out.println(isMyValue100);
        System.out.println(sampleData);

        // 스프링 AOP
        eventService.createEvent();
        eventService.publishEvent();
        eventService.deleteEvent();

        // null safety
        String libraryName = libraryService.createLibrary("Ari");
    }


}
