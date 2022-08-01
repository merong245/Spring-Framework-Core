package me.hol22mol22.core.library;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    @NonNull
    public String createLibrary(@NonNull String name){
        return "hello " + name;
    }
}
