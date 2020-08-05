package com.data.app.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
@Data
public class Invoice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer invoice_id;
    @Column
    private Date invoice_date;
    @OneToOne
    @JoinColumn(name = "salesId")
    private Sale sale;
}
