package edu.chdtu.dao;

import java.util.List;


public interface ImmutableGenericDao<E, K> {

    public E find(K key);

    public List<E> getAll();
}