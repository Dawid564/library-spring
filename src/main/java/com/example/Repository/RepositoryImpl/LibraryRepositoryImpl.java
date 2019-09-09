package com.example.Repository.RepositoryImpl;

import com.example.Repository.LibraryRepository;
import com.example.domain.Books;
import org.springframework.stereotype.Repository;

@Repository
public class LibraryRepositoryImpl implements LibraryRepository{

    private Books booksData = null;

    @Override
    public void fillUpRepository(Books books) {
        this.booksData = books;
    }

    @Override
    public Books getBookData() {
        return booksData;
    }
}
