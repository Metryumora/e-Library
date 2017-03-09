package edu.chdtu.service;

import java.util.List;

/**
 * Generic Service
 */
public interface ImmutableGenericService<E, K> {

    public List<E> getAll();

    public E get(K id);
}
