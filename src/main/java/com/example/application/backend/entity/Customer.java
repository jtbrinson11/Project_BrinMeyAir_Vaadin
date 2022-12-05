package com.example.application.backend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Customer extends AbstractEntity implements Cloneable{
    @OneToMany(mappedBy = "shipment", fetch = FetchType.EAGER)
    private List<Shipment> orderList = new LinkedList<>();

    private String location;

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;

    public List<Shipment> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Shipment> orderList) {
        this.orderList = orderList;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return username;
    }
}
