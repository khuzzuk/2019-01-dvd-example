package com.example.dvdexample.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
public class Payment {
    @Id
    @Column(name = "payment_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;
    private BigDecimal amount;
}
