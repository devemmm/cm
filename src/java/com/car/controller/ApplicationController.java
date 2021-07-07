/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.car.controller;

import com.car.domain.Car;
import com.car.model.CarModel;
import com.car.service.CarService;
import com.car.service.CarServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author emmanuel
 */
@WebServlet(name = "ApplicationController", urlPatterns = {"/applicationController.do"})
public class ApplicationController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            RequestDispatcher currentPage = request.getRequestDispatcher("index.jsp");
            RequestDispatcher carList = request.getRequestDispatcher("carList.jsp");
            RequestDispatcher editPage = request.getRequestDispatcher("editCar.jsp");
            RequestDispatcher errorPage = request.getRequestDispatcher("deleteCar.jsp");
            
            Car car = new Car();
            CarService carService = new CarServiceImpl();
            CarModel carModel = (CarModel) request.getAttribute("carModel");
            
            if(carModel == null){
                carModel = new CarModel();
                request.setAttribute("carModel", carModel);
            }
            
            switch(request.getParameter("type")){
                case "save":
                    if(carModel.applyRequestValues(request)){
                        currentPage.forward(request, response);
                    }else if(carModel.processValidation()){
                        currentPage.forward(request, response);
                    }else if(carModel.invokeApplication()){
                        currentPage.forward(request, response);
                    }else{
                        carList.forward(request, response);
                    }
                    break;
                case "edit":
                    try {
                        car = new Car(request.getParameter("plateNo"), 
                                LocalDate.parse(request.getParameter("manufacturedDate")), 
                                Long.parseLong(request.getParameter("cost")), 
                                request.getParameter("institution"));
                        String plateNo = request.getParameter("plateNo");
                        carService.updateCar(car);

                        carList.forward(request, response);
                    } catch (Exception e) {
                        editPage.forward(request, response);
                    }
                    
                    break;
                case "delete":
                    try {
                        String plateNo = request.getParameter("plateNo");
                        carService.deleteCar(plateNo);

                        carList.forward(request, response);
                    } catch (Exception e) {
                        currentPage.forward(request, response);
                    }
                    
                    break;
                default:
                    errorPage.forward(request, response);
                    break;
                
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
