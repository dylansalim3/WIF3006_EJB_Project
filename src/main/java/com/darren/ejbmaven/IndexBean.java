/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darren.ejbmaven;

import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Darren
 */
@ManagedBean
@RequestScoped

public class IndexBean {
    /**
     * Creates a new instance of IndexBean
     */
    
    private double simpleInterest;
    private String message = "Hello Welcome to Darren page";
    private double principle;
    private int years;
    private double interest;
    
     public void setSimpleInterest(double simpleInterest){
        this.simpleInterest = simpleInterest;
    }
    
    public double getSimpleInterest(){
        return simpleInterest;
    }
    
    public void setPrinciple(double principle){
        this.principle = principle;
    }
    
    public double getPrinciple(){
        return principle;
    }
    
    public void setMessage(String message){
        this.message = message;
    }
    
    public String getMessage(){
        return message;
    }
    
    public void setInterest(double interest){
        this.interest = interest;
    }
    
    public double getInterest(){
        return interest;
    }
    
    public void setYears(int years){
        this.years = years;
    }
    
    public int getYears(){
        return years;
    }
    
    public String calculateSI(){
        simpleInterest = principle * interest * years;
        return "index";
    }
    
}
