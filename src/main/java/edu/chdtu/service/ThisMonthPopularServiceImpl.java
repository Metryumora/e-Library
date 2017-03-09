package edu.chdtu.service;

import edu.chdtu.dao.ImmutableGenericDao;
import edu.chdtu.dao.ThisMonthPopularDao;
import edu.chdtu.model.ThisMonthPopular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Supreme on 09.12.2016.
 */

@Service
public class ThisMonthPopularServiceImpl extends ImmutableGenericServiceImpl<ThisMonthPopular, Integer> implements ThisMonthPopularService {

    ThisMonthPopularDao thisMonthPopularDao;

    @Autowired
    public ThisMonthPopularServiceImpl(@Qualifier("thisMonthPopularDaoImpl") ImmutableGenericDao<ThisMonthPopular, Integer> immutableGenericDao) {
        super(immutableGenericDao);
        this.thisMonthPopularDao = (ThisMonthPopularDao) immutableGenericDao;
    }
}
