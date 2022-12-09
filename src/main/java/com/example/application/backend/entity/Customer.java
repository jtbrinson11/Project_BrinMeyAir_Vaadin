package com.example.application.backend.entity;

import com.vaadin.flow.data.binder.PropertyId;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Customer extends AbstractEntity implements Cloneable{
    //@OneToMany(mappedBy = "shipment", fetch = FetchType.EAGER)
    //private List<Shipment> orderList = new LinkedList<>();

    private String location;
    private String username;
    private String password;

    @NotNull
    @NotEmpty
    @PropertyId("firstName")
    private String firstName;

    @NotNull
    @NotEmpty
    @PropertyId("lastName")
    private String lastName;

    @NotNull
    @NotEmpty
    @PropertyId("email")
    private String email;

    @NotNull
    @NotEmpty
    @PropertyId("phone")
    private String phone;

    //public List<Shipment> getOrderList() {
      //  return orderList;
    //}

    //public void setOrderList(List<Shipment> orderList) {
       // this.orderList = orderList;
    //}


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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return username;
    }
}
