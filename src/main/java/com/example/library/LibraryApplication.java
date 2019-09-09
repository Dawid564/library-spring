package com.example.library;

import com.example.Service.LibraryService;
import com.example.domain.Books;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;

@SpringBootApplication
@ComponentScan({"com.example"})
public class LibraryApplication implements ApplicationRunner {

	@Autowired
	LibraryService libraryService;

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String argument = "books.json";//default value

	    try{
            argument = args.getNonOptionArgs().get(0);
        }catch (Exception e){
	        e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();

        Books books = mapper.readValue(new File(argument),Books.class);
        libraryService.fillUpRepository(books);
    }
}
