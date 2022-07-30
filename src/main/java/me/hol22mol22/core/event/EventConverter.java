package me.hol22mol22.core.event;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class EventConverter {

//    @Component
    public static class String2EventConverter implements Converter<String, Event> {
        @Override
        public Event convert(String source) {
            return new Event(Integer.parseInt(source));
        }
    }

//    @Component
    public static class Event2StringConverter implements Converter<Event,String>{
        @Override
        public String convert(Event source) {
            return source.getId().toString();
        }
    }

}
