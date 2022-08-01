package me.hol22mol22.core.event;

import me.hol22mol22.core.PerfLogging;
import org.springframework.stereotype.Service;

@Service
public class SimpleEventService implements EventService{

    // real subject
    @Override
    @PerfLogging
    public void createEvent() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Created an event");
    }

    @Override
    @PerfLogging
    public void publishEvent() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Published an event");
    }

    @Override
    public void deleteEvent() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Deleted an event");
    }
}
