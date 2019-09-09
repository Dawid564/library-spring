package com.example.Repository;

import com.example.domain.Books;

public interface LibraryRepository {

    void fillUpRepository(Books books);
    Books getBookData();
}
