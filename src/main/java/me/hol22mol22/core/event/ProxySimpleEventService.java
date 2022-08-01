package me.hol22mol22.core.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class ProxySimpleEventService implements EventService{

    @Autowired
    SimpleEventService simpleEventService;

    // 프록시 프로젝트
    @Override
    public void createEvent() {
        long begin = System.currentTimeMillis();
        simpleEventService.createEvent();
        System.out.println(System.currentTimeMillis()-begin);

    }

    @Override
    public void publishEvent() {

        long begin = System.currentTimeMillis();
        simpleEventService.publishEvent();

        System.out.println(System.currentTimeMillis()-begin);

    }

    @Override
    public void deleteEvent() {
        simpleEventService.deleteEvent();
    }
}
