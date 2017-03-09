package edu.chdtu.service;

import edu.chdtu.model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Supreme on 09.12.2016.
 */

@Service
@Repository
@Transactional
public interface BookService extends GenericService<Book, Integer> {

    public List<Book> searchByName(String name, int sortBy, int order);

    public List<Book> searchByAuthor(String author, int sortBy, int order);

    public List<Book> getAll(int sortBy, int order);
}
