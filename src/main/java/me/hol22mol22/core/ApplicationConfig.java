package me.hol22mol22.core;

import me.hol22mol22.core.book.BookRepository;
import me.hol22mol22.core.book.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = CoreApplication.class)
public class ApplicationConfig {

}
