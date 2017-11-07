package com.example.leo.mvpdemo.dao;

import com.example.leo.mvpdemo.entity.IEntity;

import java.util.Collection;
import java.util.List;


public interface IDao<T extends IEntity> {
    List<T> listAll();
    void add(T entity);
    void update(T entity);
    void delete(T entity);
}
