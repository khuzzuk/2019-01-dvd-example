package com.example.dvdexample.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(of = "title")
@Getter
@Setter
@Entity
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Film {
    @Id
    @Column(name = "film_id")
    private Integer id;
    @NaturalId
    private String title;
    @OneToMany(mappedBy = "film", fetch = FetchType.LAZY)
    private Set<Inventory> inventories;
}
