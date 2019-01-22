package com.example.dvdexample.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Inventory {
    @Id
    @Column(name = "inventory_id")
    private Integer id;
    @OneToMany(mappedBy = "inventory")
    private Set<Rental> rentals;
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
}
