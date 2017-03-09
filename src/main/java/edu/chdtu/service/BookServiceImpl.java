package edu.chdtu.service;

import edu.chdtu.dao.BookDao;
import edu.chdtu.dao.GenericDao;
import edu.chdtu.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Supreme on 09.12.2016.
 */

@Service
public class BookServiceImpl extends GenericServiceImpl<Book, Integer> implements BookService {

    BookDao bookDao;

    @Autowired
    public BookServiceImpl(@Qualifier("bookDaoImpl") GenericDao<Book, Integer> genericDao) {
        super(genericDao);
        this.bookDao = (BookDao) genericDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Book> searchByName(String name, int sortBy, int order) {
        return bookDao.searchByName(name, sortBy, order);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Book> searchByAuthor(String author, int sortBy, int order) {
        return bookDao.searchByAuthor(author, sortBy, order);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Book> getAll(int sortBy, int order) {
        return bookDao.getAll();
    }
}
