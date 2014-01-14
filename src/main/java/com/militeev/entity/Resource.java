package com.militeev.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Resource extends AbstractEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = true, length = 1000)
    private String description;

    public Resource() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
