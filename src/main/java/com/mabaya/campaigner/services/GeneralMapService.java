package com.mabaya.campaigner.services;

import com.mabaya.campaigner.model.BaseEntity;

import java.util.*;

public abstract class GeneralMapService<T extends BaseEntity, ID extends Integer> {

    private Map<Integer, Object> map;

    T findById(ID id, Map map) {
        this.map = map;
        return (T) map.get(id);
    }

    T save(T object, Map map) {
        this.map = map;
        if(object != null) {
            if(object.getId() == null){
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }

        return object;
    }

    private Integer getNextId() {
         try {
             return Collections.max(map.keySet()) + 1;
         } catch (NoSuchElementException e) {
             return 1;
         }
    }
}
