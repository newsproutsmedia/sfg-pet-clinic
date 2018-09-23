package com.newsproutsmedia.sfgpetclinic.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity implements Serializable {

    // GenerationType.IDENTITY indicates that the dB provider (MySQL, H2, etc) should determine the appropriate strategy for ID generation
    // IDENTITY allows you to be more flexible in how IDs are created
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }
}
