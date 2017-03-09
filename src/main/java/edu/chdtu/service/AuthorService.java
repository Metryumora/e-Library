package edu.chdtu.service;

import edu.chdtu.model.Author;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Supreme on 09.12.2016.
 */

@Service
@Repository
@Transactional
public interface AuthorService extends GenericService<Author, Integer> {

    public List<Author> searchByName(String name, int sortBy, int order);

    public List<Author> searchByName(String name);

}
