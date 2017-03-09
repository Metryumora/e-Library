package edu.chdtu.service;

import edu.chdtu.model.Download;
import edu.chdtu.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Supreme on 10.12.2016.
 */

@Service
@Repository
@Transactional
public interface DownloadService extends GenericService<Download, Integer> {

    public List<Download> getForUser(User user);

    public void deactivateDownloadsForUser(User user);
}
