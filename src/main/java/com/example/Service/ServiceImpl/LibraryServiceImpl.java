package com.example.Service.ServiceImpl;

import com.example.Repository.LibraryRepository;
import com.example.Service.LibraryService;
import com.example.domain.Books;
import com.example.domain.IndustryIdentifier;
import com.example.domain.Item;
import com.example.view.BookIsbn;
import com.example.view.RatingBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    LibraryRepository libraryRepository;

    @Override
    public void fillUpRepository(Books books) {
        libraryRepository.fillUpRepository(books);
    }

    @Override
    public BookIsbn getBookByIsbn(String isbn) {
        Books books = libraryRepository.getBookData();
        Item item = getItemByIsbn(isbn, books);
        if(null != item){
            return fillUpBookIsbn(item);
        }else{
            return null;
        }
    }

    @Override
    public List<BookIsbn> getBooksByCategory(String category) {
        return getBookIsbnList(getItemByCategory(category,libraryRepository.getBookData()));
    }

    @Override
    public List<RatingBook> getRatingBook() {
        Books books = libraryRepository.getBookData();
        List<RatingBook> ratingBooks = new ArrayList<>();

        for(Item item : books.getItems()){
            List<RatingBook> tmpRatingBooks;
            tmpRatingBooks = convertItemToRatingBook(item);
            for (RatingBook ratingBook : tmpRatingBooks){
                ratingBooks.add(ratingBook);
            }
        }
        ratingBooks = cleanList(ratingBooks);
        Collections.sort(ratingBooks);
        return ratingBooks;
    }

    //clean list from not rated book
    private List<RatingBook> cleanList(List<RatingBook> list){
        List<RatingBook> ratingBooks = new ArrayList<>();
        for (RatingBook r : list){
            if(null != r.getAverageRating()){
                ratingBooks.add(r);
            }
        }

        //remove duplicates
        List<RatingBook> result = new ArrayList<>();
        Set<String> authors = new HashSet<>();
        for (RatingBook r : ratingBooks){
            if(authors.add(r.getAuthor())){
                result.add(r);
            }
        }
        return result;
    }

    private List<RatingBook> convertItemToRatingBook(Item item){
        RatingBook ratingBook = new RatingBook();
        List<RatingBook> ratingBooks = new ArrayList<>();
        for (int i=0; i<item.getVolumeInfo().getAuthors().size(); i++){
            ratingBook.setAuthor(item.getVolumeInfo().getAuthors().get(i));
            ratingBook.setAverageRating(item.getVolumeInfo().getAverageRating());
            ratingBooks.add(ratingBook);
        }
        return ratingBooks;
    }

    private List<BookIsbn> getBookIsbnList(List<Item> items){
        List<BookIsbn> bookIsbns = new ArrayList<>();
        for(Item i : items){
            bookIsbns.add(fillUpBookIsbn(i));
        }
        return bookIsbns;
    }

    private List<Item> getItemByCategory(String category, Books books){
        List<Item> itemList = new ArrayList<>();
        boolean flag;
        for(Item item : books.getItems()){
            flag = true;
            for(String itemCategory : item.getVolumeInfo().getCategories()){
                if(itemCategory.equalsIgnoreCase(category) && flag){
                    itemList.add(item);
                    flag = false;
                }
            }
        }
        return itemList;
    }

    private BookIsbn fillUpBookIsbn(Item item){
        BookIsbn bookIsbn = new BookIsbn();
        bookIsbn.setIsbn(getIsbnOrId(item));
        bookIsbn.setTitle(item.getVolumeInfo().getTitle());
        bookIsbn.setSubtitle(item.getVolumeInfo().getSubtitle());
        bookIsbn.setPublisher(item.getVolumeInfo().getPublisher());
        bookIsbn.setPublishedDate(item.getVolumeInfo().getPublishedDate());
        bookIsbn.setDescription(item.getVolumeInfo().getDescription());
        bookIsbn.setPageCount(item.getVolumeInfo().getPageCount());
        bookIsbn.setThumbnailUrl(item.getVolumeInfo().getImageLinks().getSmallThumbnail());
        bookIsbn.setLanguage(item.getVolumeInfo().getLanguage());
        bookIsbn.setPreviewLink(item.getVolumeInfo().getPreviewLink());
        bookIsbn.setAverageRating(item.getVolumeInfo().getAverageRating());
        bookIsbn.setAuthors(item.getVolumeInfo().getAuthors());
        bookIsbn.setCategories(item.getVolumeInfo().getCategories());
        return bookIsbn;
    }

    private String getIsbnOrId(Item item){
        for (IndustryIdentifier id : item.getVolumeInfo().getIndustryIdentifiers()){
            if (null != id.getIdentifier() && id.getType().equalsIgnoreCase("ISBN_13")){
                return id.getIdentifier();
            }
        }
        return item.getId();
    }

    private Item getItemByIsbn(String isbn, Books books){
        for (Item item : books.getItems()){
            for(IndustryIdentifier id : item.getVolumeInfo().getIndustryIdentifiers()){
                if(id.getIdentifier().equals(isbn) && id.getType().equalsIgnoreCase("ISBN_13")){
                    //if found in isbn
                    return item;
                }
            }
            if(item.getId().equals(isbn)){
                //if found in book id
                return item;
            }
        }
        //if not found
        return null;
    }
}
