package me.hol22mol22.core;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MyEvent{

    public int getData() {
        return data;
    }

    @Min(0)
    private int data;
    @NotEmpty
    private String title;
    public MyEvent(int data, String title) {
        this.data = data;
        this.title = title;
    }


    private Object source;

    public MyEvent(String title, Object source){
        this.title = title;
        this.source = source;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Object getSource() {
        return source;
    }

    public MyEvent(Object source, int data, String title) {
        this.source = source;
        this.data = data;
        this.title = title;
    }
}
