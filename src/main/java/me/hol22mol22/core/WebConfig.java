package me.hol22mol22.core;

import me.hol22mol22.core.event.EventConverter;
import me.hol22mol22.core.event.EventFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 스프링 부트의 WebConversionService를 이용하기 위해 주석 처리
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
////        registry.addConverter(new EventConverter.String2EventConverter());
//        registry.addFormatter(new EventFormatter());
//    }
//
//}
