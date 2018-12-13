package com.esliceu.dwes.xavi.modules;


import java.util.List;

public interface EntityManager<T> {

    T getItemById(T item);

    List<T> getAll();

    void deleteById(T item) throws Exception;
}
