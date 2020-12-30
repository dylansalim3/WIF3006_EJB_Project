/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darren.fitnesscalculator.models;

import javax.ejb.Remote;

/**
 *
 * @author Darren
 */
@Remote
public interface PersonalInfoRemote {
    int getAge();
    Double getHeight();
    Double getWeight();    
    String getGender();
    int getExerciseLevelId();
    String getCalorieFormula();
    double getBodyFat();
    String getPersonalInfo();
    
    void setAge(int age);
    void setHeight(Double height);
    void setWeight(Double weight);
    void setGender(String gender);
    void setExerciseLevelId(int exerciseLevelId);
    void setCalorieFormula(String calorieFormula);
    void setBodyFat(double bodyFat);
}
