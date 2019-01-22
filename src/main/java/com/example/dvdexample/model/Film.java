package com.example.dvdexample.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Film {
    @Id
    @Column(name = "film_id")
    private Integer id;
    private String title;
    @OneToMany(mappedBy = "film", fetch = FetchType.LAZY)
    private Set<Inventory> inventories;
}
