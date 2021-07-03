package com.example.gestionAchat.Model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@MappedSuperclass
public class AbstractEntity implements Serializable {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

}
