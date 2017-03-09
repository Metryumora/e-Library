package edu.chdtu.dao;

import edu.chdtu.model.Book;

import java.util.List;

/**
 * Created by Supreme on 09.12.2016.
 */
public interface BookDao extends GenericDao<Book, Integer> {

    public List<Book> searchByName(String name, int sortBy, int order);

    public List<Book> searchByAuthor(String author, int sortBy, int order);


}
