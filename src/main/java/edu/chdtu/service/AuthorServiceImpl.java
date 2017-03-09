package edu.chdtu.service;

import edu.chdtu.dao.AuthorDao;
import edu.chdtu.dao.GenericDao;
import edu.chdtu.model.Author;
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
public class AuthorServiceImpl extends GenericServiceImpl<Author, Integer> implements AuthorService {

    AuthorDao authorDao;

    @Autowired
    public AuthorServiceImpl(@Qualifier("authorDaoImpl") GenericDao<Author, Integer> genericDao) {
        super(genericDao);
        this.authorDao = (AuthorDao) genericDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Author> searchByName(String name, int sortBy, int order) {
        return authorDao.searchByName(name, sortBy, order);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Author> searchByName(String name) {
        return authorDao.searchByName(name);
    }
}
