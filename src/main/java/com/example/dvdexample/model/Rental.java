package com.example.dvdexample.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Rental {
    @Id
    @Column(name = "rental_id")
    private Integer id;
    @OneToMany(mappedBy = "rental")
    private Set<Payment> payments;
    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;
}
