package edu.chdtu.dao;

import edu.chdtu.model.Book;
import edu.chdtu.service.AuthorService;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Supreme on 09.12.2016.
 */
@Repository
@Transactional
public class BookDaoImpl extends GenericDaoImpl<Book, Integer> implements BookDao {

    public static final int ORDER_ASC = 0;

    public static final int ORDER_DESC = 1;

    public static final int SORT_BY_NAME = 0;

    public static final int SORT_BY_PUBLISHING = 1;

    public static final int SEARCH_BY_AUTHOR = 0;

    public static final int SEARCH_BY_NAME = 1;

    @Autowired
    AuthorService authorService;

    @Override
    public List<Book> searchByName(String name, int sortBy, int order) {
        Criteria searchCriteria = getCriteria(sortBy, order);
        searchCriteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
        return searchCriteria.list();
    }

    private Criteria getCriteria(int sortBy, int order) {
        Criteria c = currentSession().createCriteria(getDaoType());
        switch (sortBy) {
            case SORT_BY_NAME: {
                c.addOrder(order == ORDER_ASC ? Order.asc("name") : order == ORDER_DESC ? Order.desc("name") : Order.asc("name"));
                break;
            }
            case SORT_BY_PUBLISHING: {
                c.addOrder(order == ORDER_ASC ? Order.asc("yearOfPublishing") : order == ORDER_DESC ? Order.desc("yearOfPublishing") : Order.asc("yearOfPublishing"));
                break;
            }
        }
        return c;
    }

    @Override
    public List<Book> searchByAuthor(String authorName, int sortBy, int order) {
        Criteria searchCriteria = getCriteria(sortBy, order);
        searchCriteria.createAlias("authors", "author");
        searchCriteria.add(Restrictions.or(
                Restrictions.like("author.name", authorName, MatchMode.ANYWHERE),
                Restrictions.like("author.surname", authorName, MatchMode.ANYWHERE)
        ));
        return searchCriteria.list();
    }

    public List<Book> getAll(int sortBy, int order) {
        return getCriteria(sortBy, order).list();
    }
}
