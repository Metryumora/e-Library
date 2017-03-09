package edu.chdtu.dao;

import edu.chdtu.model.Download;
import edu.chdtu.model.User;

import java.util.List;

/**
 * Created by Supreme on 09.12.2016.
 */
public interface DownloadDao extends GenericDao<Download, Integer> {

    public List<Download> getForUser(User user);

    public void deactivateDownloadsForUser(User user);
}
