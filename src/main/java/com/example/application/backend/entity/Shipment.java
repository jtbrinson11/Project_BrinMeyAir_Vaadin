package com.example.application.backend.entity;

import com.vaadin.flow.data.binder.PropertyId;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Shipment extends AbstractEntity implements Cloneable{

    public enum status {
        labelCreated, shipped, outForDelivery, delivered
    }

    public enum measureSystem {
        imperial, metric
    }

    //@OneToOne
    //@JoinColumn(name = "customer_id")
    //private Customer customer;

    //@OneToOne
    //@JoinColumn(name = "service_id")
    //private Service service;

    @Enumerated(EnumType.STRING)
    @NotNull
    @PropertyId("status")
    private Shipment.status status;

    @Enumerated(EnumType.STRING)
    @NotNull
    @PropertyId("measure")
    private Shipment.measureSystem measureSystem;

    @NotNull
    @NotEmpty
    @PropertyId("length")
    private double length;

    @NotNull
    @NotEmpty
    @PropertyId("width")
    private double width;

    @NotNull
    @NotEmpty
    @PropertyId("height")
    private double height;

    @NotNull
    @NotEmpty
    @PropertyId("weight")
    private double weight;

    @NotNull
    @NotEmpty
    @PropertyId("hazard")
    private boolean hazard;

    @NotNull
    @NotEmpty
    @PropertyId("perish")
    private boolean perish;

    public Shipment.status getStatus() {
        return status;
    }

    public void setStatus(Shipment.status status) {
        this.status = status;
    }

    public Shipment.measureSystem getMeasureSystem() {
        return measureSystem;
    }

    public void setMeasureSystem(Shipment.measureSystem measureSystem) {
        this.measureSystem = measureSystem;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isHazard() {
        return hazard;
    }

    public void setHazard(String hazardStr) {
        if (hazardStr.equals("Yes")) {
            hazard = true;
        } else if (hazardStr.equals("No")) {
            hazard = false;
        }
    }

    public boolean isPerish() {
        return perish;
    }

    public void setPerish(String perishStr) {
        if (perishStr.equals("Yes")) {
            perish = true;
        } else if (perishStr.equals("No")) {
            perish = false;
        }
    }
}
