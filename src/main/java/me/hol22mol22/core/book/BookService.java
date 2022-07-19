package me.hol22mol22.core.book;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BookService {


    //private BookRepository bookRepository = new BookRepository();

    // Inversion of Control: 의존관계 주입 DI 라고도 함.
    // 어떤 객체가 사용하는 의존 객체를 직접 만들어 사용하는 것이 아닌 주입 받아서 사용
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Book save(Book book){
        book.setCreated(new Date());
        book.setBookStatus(BookStatus.DRAFT);
        return bookRepository.save(book);
    }

}
