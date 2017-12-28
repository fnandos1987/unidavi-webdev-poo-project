package br.edu.unidavi.oscar.persistence;

import java.util.ArrayList;

public interface IDao<T, V> {

    public Boolean save(V entity);
    public Boolean update(V entity);
    public Boolean delete(V entity);
    public ArrayList<V> findAll();
    public V findById(T id);
}
