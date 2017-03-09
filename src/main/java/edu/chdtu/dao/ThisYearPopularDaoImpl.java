package edu.chdtu.dao;

import edu.chdtu.model.ThisYearPopular;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Supreme on 09.12.2016.
 */
@Repository
@Transactional
public class ThisYearPopularDaoImpl extends ImmutableGenericDaoImpl<ThisYearPopular, Integer> implements ThisYearPopularDao {

}
