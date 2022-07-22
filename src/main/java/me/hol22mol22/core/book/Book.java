package me.hol22mol22.core.book;

import java.util.Date;

public class Book {

    private Date created;

    private BookStatus bookStatus;

    public Date getCreated(){
        return created;
    }
    public Date setCreated(Date date){
        return this.created = date;
    }

    public BookStatus getBookStatus(){
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus){
        this.bookStatus = bookStatus;
    }


}
