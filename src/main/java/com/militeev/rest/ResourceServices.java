package com.militeev.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.militeev.dao.ResourceDAO;
import com.militeev.entity.Resource;

@Component
@Path("resources")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
@Transactional
public class ResourceServices extends AbstractServices<Resource> {
    
    @Autowired
    private ResourceDAO resourceDAO;

    public ResourceServices() {
    }

    @Override
    protected ResourceDAO getDAO() {
        return resourceDAO;
    }
    
    
}
