package com.example.Service;

import com.example.domain.Books;
import com.example.view.BookIsbn;
import com.example.view.RatingBook;

import java.util.List;

public interface LibraryService {

    void fillUpRepository(Books books);
    BookIsbn getBookByIsbn(String isbn);
    List<BookIsbn> getBooksByCategory(String category);
    List<RatingBook> getRatingBook();
}
