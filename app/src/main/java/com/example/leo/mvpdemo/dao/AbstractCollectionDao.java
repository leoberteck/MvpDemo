package com.example.leo.mvpdemo.dao;

import com.example.leo.mvpdemo.entity.IEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by leo on 11/6/17.
 */

public abstract class AbstractCollectionDao<T extends IEntity> implements IDao<T> {

    protected List<T> allEntities = new ArrayList<>();

    @Override
    public List<T> listAll() {
        return allEntities;
    }

    @Override
    public void add(T entity) {
        if(entity.getId() == null){
            entity.setId(getNewId());
        }
        allEntities.add(entity);
    }

    @Override
    public void update(T entity) {
        int index = allEntities.indexOf(entity);
        if(index >= 0){
            allEntities.set(index, entity);
        }
    }

    @Override
    public void delete(T entity) {
        allEntities.remove(entity);
    }

    /**
     * Retorna o maior id +1
     * @return
     */
    private Integer getNewId(){
        List<Integer> allIds = new ArrayList<>();
        for (T entity : allEntities) {
            allIds.add(entity.getId());
        }
        return allIds.size() > 0 ? Collections.max(allIds) + 1 : 1;
    }
}
