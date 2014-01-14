package com.militeev.dao;

import org.springframework.stereotype.Repository;

import com.militeev.entity.Resource;

@Repository
public class ResourceDAO extends AbstractDAO<Resource> {

    public ResourceDAO() {
        super(Resource.class);
    }
    
}
