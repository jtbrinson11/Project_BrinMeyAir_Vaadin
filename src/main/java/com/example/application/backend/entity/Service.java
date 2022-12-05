package com.example.application.backend.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Service extends AbstractEntity implements Cloneable{

    public enum serviceTypes {
        slowest, slower, normal, quicker, quickest
    }
    @NotNull
    @NotEmpty
    @OneToOne(mappedBy = "service", fetch = FetchType.EAGER)
    private serviceTypes name;

    @NotNull
    @NotEmpty
    private String speed;

    @NotNull
    @NotEmpty
    private String requirements;

    public serviceTypes getName() {
        return name;
    }

    public void setName(serviceTypes name) {
        this.name = name;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    @Override
    public String toString() {
        return name.name();
    }
}
