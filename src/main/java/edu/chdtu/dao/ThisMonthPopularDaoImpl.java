package edu.chdtu.dao;

import edu.chdtu.model.ThisMonthPopular;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Supreme on 09.12.2016.
 */
@Repository
@Transactional
public class ThisMonthPopularDaoImpl extends ImmutableGenericDaoImpl<ThisMonthPopular, Integer> implements ThisMonthPopularDao {

}
