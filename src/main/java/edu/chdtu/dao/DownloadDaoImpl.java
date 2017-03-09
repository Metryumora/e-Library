package edu.chdtu.dao;

import edu.chdtu.model.Download;
import edu.chdtu.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.CallableStatement;
import java.util.List;

/**
 * Created by Supreme on 09.12.2016.
 */
@Repository
@Transactional
public class DownloadDaoImpl extends GenericDaoImpl<Download, Integer> implements DownloadDao {

    @Override
    public List<Download> getForUser(User user) {
        List<Download> downloads;
        Criteria criteria = currentSession().createCriteria(daoType);
        criteria.add(Restrictions.eq("user.id", user.getId()));
        criteria.add(Restrictions.eq("active", true));
        criteria.addOrder(Order.desc("downloadTimestamp"));
        downloads = criteria.list();
        return downloads;
    }

    @Override
    public void deactivateDownloadsForUser(User user) {
        currentSession().doWork(connection -> {
                    try (CallableStatement procedure = connection.prepareCall(
                            "{ call deactivate_downloads(?) }")) {
                        procedure.setInt(1, user.getId());
                        procedure.execute();
                    }
                }
        );
    }
}
