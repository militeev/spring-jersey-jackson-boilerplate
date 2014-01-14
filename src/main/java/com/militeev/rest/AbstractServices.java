package com.militeev.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import com.militeev.dao.AbstractDAO;
import com.militeev.entity.AbstractEntity;

@Transactional
public abstract class AbstractServices<T extends AbstractEntity> {
    
    abstract protected AbstractDAO<T> getDAO();

    public AbstractServices() {
    }
    
    @GET
    @Path("{id}")
    public T get(@PathParam("id") long id) {
        T t = getDAO().findOne(id);
        if (t == null) {
            throw new WebApplicationException(Status.NOT_FOUND);
        }
        return t;
    }

    @GET
    public List<T> getAll(@PathParam("id") long id) {
        List<T> list = getDAO().findAll();
        return list;
    }
    
    @POST
    public T create(T t) {
        return getDAO().create(t);
    }

    @PUT
    @Path("{id}")
    public T update(@PathParam("id") long id, T t) {
        if (id != t.getId()) {
            throw new WebApplicationException(Status.BAD_REQUEST);
        }
        T existing = getDAO().findOne(t.getId());
        if (existing == null) {
            throw new WebApplicationException(Status.NOT_FOUND);
        }
        BeanUtils.copyProperties(t, existing);
        return getDAO().update(t);
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") long id) {
        T t = get(id);
        if (t == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        getDAO().delete(t);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    
}
