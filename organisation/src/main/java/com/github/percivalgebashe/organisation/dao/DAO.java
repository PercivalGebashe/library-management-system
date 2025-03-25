package com.github.percivalgebashe.organisation.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    List<T> getAll();

    void create(T t);

    Optional<T> getById(String id);

    void update(T t);

    void delete(String id);
}
