/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.car.service;

import com.car.domain.Car;
import java.util.List;

/**
 *
 * @author emmanuel
 */
public interface CarService {
    public String registerCar(Car car);
    public String updateCar(Car car);
    public boolean deleteCar(String plateNo);
    public List<Car> carList();
}
