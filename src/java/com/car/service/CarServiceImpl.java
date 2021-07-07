/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.car.service;

import com.car.dao.GeneralDao;
import com.car.domain.Car;
import java.util.List;

/**
 *
 * @author emmanuel
 */
public class CarServiceImpl implements CarService{

    GeneralDao<Car> carDao = new GeneralDao<>(Car.class);
    Car car = new Car();
    @Override
    public String registerCar(Car car) {
        
        
        
        try {
            carDao.create(car);
            
            return "Car Saved Successfull";
        } catch (Exception e) {
            throw new RuntimeException("alredy car was exist in database");
        }
    }

    @Override
    public String updateCar(Car car) {
        try {
            carDao.update(car);
            
            return "Car information updated successfull";
        } catch (Exception e) {
            throw new RuntimeException("Internal Server error");
        }
    }

    @Override
    public boolean deleteCar(String plateNo) {
        try {
            car = carDao.findBySTRING_PK(plateNo);
            carDao.delete(car);
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Car> carList() {
        try {
            return carDao.listAll();
        } catch (Exception e) {
            return null;
        }
    }
    
}
