package edu.chdtu.dao;

import edu.chdtu.model.Author;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Supreme on 09.12.2016.
 */
@Repository
@Transactional
public class AuthorDaoImpl extends GenericDaoImpl<Author, Integer> implements AuthorDao {

    public static final int ORDER_ASC = 0;

    public static final int ORDER_DESC = 1;

    public static final int SORT_BY_NAME = 0;

    public static final int SORT_BY_PUBLISHING = 1;

    @Override
    public List<Author> searchByName(String authorName, int sortBy, int order) {
        Criteria searchCriteria = getCriteria(sortBy, order);
        searchCriteria.add(
                Restrictions.or(
                        Restrictions.like("name", authorName, MatchMode.ANYWHERE),
                        Restrictions.like("surname", authorName, MatchMode.ANYWHERE)
                )
        );
        return searchCriteria.list();
    }

    public List<Author> searchByName(String authorName) {
        return currentSession()
                .createCriteria(Author.class)
                .add(
                        Restrictions.or(
                                Restrictions.like("name", authorName, MatchMode.ANYWHERE),
                                Restrictions.like("surname", authorName, MatchMode.ANYWHERE)
                        )
                ).list();
    }

    private Criteria getCriteria(int sortBy, int order) {
        Criteria c = currentSession().createCriteria(daoType);
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
}
