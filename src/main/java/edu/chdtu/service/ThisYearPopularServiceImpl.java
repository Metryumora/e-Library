package edu.chdtu.service;

import edu.chdtu.dao.ImmutableGenericDao;
import edu.chdtu.dao.ThisYearPopularDao;
import edu.chdtu.model.ThisYearPopular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Supreme on 09.12.2016.
 */

@Service
public class ThisYearPopularServiceImpl extends ImmutableGenericServiceImpl<ThisYearPopular, Integer> implements ThisYearPopularService {

    ThisYearPopularDao thisYearPopularDaoPopularDao;

    @Autowired
    public ThisYearPopularServiceImpl(@Qualifier("thisYearPopularDaoImpl") ImmutableGenericDao<ThisYearPopular, Integer> immutableGenericDao) {
        super(immutableGenericDao);
        this.thisYearPopularDaoPopularDao = (ThisYearPopularDao) immutableGenericDao;
    }
}
