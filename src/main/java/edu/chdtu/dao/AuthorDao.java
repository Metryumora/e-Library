package edu.chdtu.dao;

import edu.chdtu.model.Author;
import edu.chdtu.model.Book;

import java.util.List;

/**
 * Created by Supreme on 09.12.2016.
 */
public interface AuthorDao extends GenericDao<Author, Integer> {

    public List<Author> searchByName(String name, int sortBy, int order);

    public List<Author> searchByName(String name);
}
