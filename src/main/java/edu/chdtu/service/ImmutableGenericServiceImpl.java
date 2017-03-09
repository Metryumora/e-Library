package edu.chdtu.service;

import edu.chdtu.dao.ImmutableGenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public abstract class ImmutableGenericServiceImpl<E, K> implements ImmutableGenericService<E, K> {

    @Autowired
    private ImmutableGenericDao<E, K> immutableGenericDao;

    public ImmutableGenericServiceImpl(ImmutableGenericDao<E, K> immutableGenericDao) {
        this.immutableGenericDao = immutableGenericDao;
    }

    public ImmutableGenericServiceImpl() {
    }


    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<E> getAll() {
        return immutableGenericDao.getAll();
    }


    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public E get(K id) {
        return immutableGenericDao.find(id);
    }
}
