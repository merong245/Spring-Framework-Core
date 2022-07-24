package me.hol22mol22.core;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventHandler{

    @EventListener
    public void eventHandler (MyEvent event) {
        System.out.println("이벤트를 받았다. 이벤트는 "+event.getData());
    }
}
