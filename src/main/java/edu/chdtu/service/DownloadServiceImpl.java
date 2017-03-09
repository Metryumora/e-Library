package edu.chdtu.service;

import edu.chdtu.dao.DownloadDao;
import edu.chdtu.dao.GenericDao;
import edu.chdtu.model.Download;
import edu.chdtu.model.User;
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
public class DownloadServiceImpl extends GenericServiceImpl<Download, Integer> implements DownloadService {

    DownloadDao downloadDao;

    @Autowired
    public DownloadServiceImpl(@Qualifier("downloadDaoImpl") GenericDao<Download, Integer> genericDao) {
        super(genericDao);
        this.downloadDao = (DownloadDao) genericDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Download> getForUser(User user) {
        return downloadDao.getForUser(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deactivateDownloadsForUser(User user) {
        downloadDao.deactivateDownloadsForUser(user);
    }
}
