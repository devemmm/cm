/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.car.domain;

import java.time.LocalDate;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author emmanuel
 */
@Entity
public class Car {
    @Id
    private String plateNo;
    @Convert(converter = LocalDateConf.class)
    private LocalDate manufacturedDate;
    private Long cost;
    private String instutution;
    
    public Car(){
        
    }

    public Car(String plateNo, LocalDate manufacturedDate, Long cost, String instutution) {
        this.plateNo = plateNo;
        this.manufacturedDate = manufacturedDate;
        this.cost = cost;
        this.instutution = instutution;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public LocalDate getManufacturedDate() {
        return manufacturedDate;
    }

    public void setManufacturedDate(LocalDate manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public String getInstutution() {
        return instutution;
    }

    public void setInstutution(String instutution) {
        this.instutution = instutution;
    }
}
