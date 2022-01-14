package com.library;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@EqualsAndHashCode
@Entity
public class Book implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "title", nullable = false)
    private String title;
    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="author_id", nullable = false)
    private Author author;
}