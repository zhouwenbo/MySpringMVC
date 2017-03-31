package com.fheebiy.repo;

import java.util.List;

/**
 * Created by cm on 2017/3/30.
 */
public interface IRepo<T> {

    void save(T obj);

    void update(Object... obj);

    T getOne(Object... obj);

    List<T> getList(Object... obj);

}
