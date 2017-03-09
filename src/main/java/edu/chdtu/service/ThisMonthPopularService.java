package edu.chdtu.service;

import edu.chdtu.model.ThisMonthPopular;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Supreme on 09.12.2016.
 */

@Service
@Repository
@Transactional
public interface ThisMonthPopularService extends ImmutableGenericService<ThisMonthPopular, Integer> {

}
