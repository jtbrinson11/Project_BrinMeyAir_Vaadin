package com.example.application.backend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Shipment extends AbstractEntity implements Cloneable{

    public enum status {
        labelCreated, shipped, outForDelivery, delivered
    }

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany
    @JoinColumn(name = "service_id")
    private Service service;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Shipment.status status;




}
