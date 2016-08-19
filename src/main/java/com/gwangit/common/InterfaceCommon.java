package com.gwangit.common;

import java.io.Serializable;
import java.util.List;


public interface InterfaceCommon<T extends Serializable> {
    T findOne(final long id);
    List<T> findAll();
    void create(final T entity);
    void update(final T entity);
    void delete(final T entity);
}
