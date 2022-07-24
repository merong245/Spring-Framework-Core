package me.hol22mol22.core;

import org.springframework.context.ApplicationEvent;

public class MyEvent{

    public int getData() {
        return data;
    }

    private int data;
    private Object source;

    public MyEvent(Object source){
        this.source = source;
    }

    public Object getSource() {
        return source;
    }

    public MyEvent(Object source, int data) {
        this.source = source;
        this.data = data;
    }
}
