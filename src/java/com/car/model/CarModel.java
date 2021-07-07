/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.car.model;

import com.car.domain.Car;
import com.car.service.CarService;
import com.car.service.CarServiceImpl;
import java.time.LocalDate;
import java.time.Period;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author emmanuel
 */
public class CarModel {
    private String inputPlateNo = "";
    private String inputManufacturedDate = "";
    private String inputPrice = "";
    private String inputInstitution = "";
    
    private String plateNoMsg = "";
    private String manaufactureDateMsg = "";
    private String priceMessage = "";
    private String institutionMsg = "";
    
    private LocalDate manufacturedDate;
    private Long price;
    
    private boolean error = false;
    private String systemMsg = "";
    
    Car car;
    CarService carService;

    public CarModel() {
    
    }
    
    public boolean applyRequestValues(HttpServletRequest request){
        
        inputPlateNo = request.getParameter("plateNo");
        inputManufacturedDate = request.getParameter("manufacturedDate");
        inputPrice = request.getParameter("cost");
        inputInstitution = request.getParameter("institution");
        
        try {
            manufacturedDate = LocalDate.parse(inputManufacturedDate);
        } catch (Exception e) {
            manaufactureDateMsg = "wrong Date input format+ ";
            error = true;
        }
        
        try {
            price = Long.parseLong(inputPrice);
        } catch (Exception e) {
            priceMessage = "wrong input price";
            error = true;
        }
        return error;
    }
    
    public boolean processValidation(){
        
        
        if((Period.between(manufacturedDate, LocalDate.now())).getYears() > 5){
            manaufactureDateMsg = "car must not be older than 5years";
            error = true;
        }
        
        if(price<15000000 || price > 60000000){
            priceMessage = "Price Shold not be in range [15,000,000 - 60,000,000]";
            error = true;
        }
        
        
        return error;
    }
    
    public void updateModelValues(){
        car = new Car(inputPlateNo, manufacturedDate, price, inputInstitution);
    }
    
    public boolean invokeApplication(){
        car = new Car(inputPlateNo, manufacturedDate, price, inputInstitution);
        
        try {
            carService = new CarServiceImpl();
            
            carService.registerCar(car);
            
            systemMsg = "Car Saved Saccessfull";
        } catch (Exception e){ 
            plateNoMsg = "already car exist";
            systemMsg = e.getMessage();
            error = true;
        }
        
        return  error;
    }
    
    

    public String getInputPlateNo() {
        return inputPlateNo;
    }

    public void setInputPlateNo(String inputPlateNo) {
        this.inputPlateNo = inputPlateNo;
    }

    public String getInputManufacturedDate() {
        return inputManufacturedDate;
    }

    public void setInputManufacturedDate(String inputManufacturedDate) {
        this.inputManufacturedDate = inputManufacturedDate;
    }

    public String getInputPrice() {
        return inputPrice;
    }

    public void setInputPrice(String inputPrice) {
        this.inputPrice = inputPrice;
    }

    public String getInputInstitution() {
        return inputInstitution;
    }

    public void setInputInstitution(String inputInstitution) {
        this.inputInstitution = inputInstitution;
    }

    public String getPlateNoMsg() {
        return plateNoMsg;
    }

    public void setPlateNoMsg(String plateNoMsg) {
        this.plateNoMsg = plateNoMsg;
    }

    public String getManaufactureDateMsg() {
        return manaufactureDateMsg;
    }

    public void setManaufactureDateMsg(String manaufactureDateMsg) {
        this.manaufactureDateMsg = manaufactureDateMsg;
    }

    public String getPriceMessage() {
        return priceMessage;
    }

    public void setPriceMessage(String priceMessage) {
        this.priceMessage = priceMessage;
    }

    public String getInstitutionMsg() {
        return institutionMsg;
    }

    public void setInstitutionMsg(String institutionMsg) {
        this.institutionMsg = institutionMsg;
    }

    public LocalDate getManufacturedDate() {
        return manufacturedDate;
    }

    public void setManufacturedDate(LocalDate manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getSystemMsg() {
        return systemMsg;
    }

    public void setSystemMsg(String systemMsg) {
        this.systemMsg = systemMsg;
    }
    
    
}
