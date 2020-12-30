/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darren.fitnesscalculator.models;

import javax.ejb.Stateful;

/**
 *
 * @author Darren
 */
@Stateful
public class PersonalInfo implements PersonalInfoRemote {
    
    private int age;
    private Double height;
    private Double weight;
    private String gender;
    private int exerciseLevelId;
    private String calorieFormula;
    private Double bodyFat;

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public Double getHeight() {
        return height;
    }

    @Override
    public Double getWeight() {
        return weight;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public int getExerciseLevelId() {
        return exerciseLevelId;
    }

    @Override
    public String getCalorieFormula() {
        return calorieFormula;
    }

    @Override
    public double getBodyFat() {
        return bodyFat;
    }

    @Override
    public String getPersonalInfo() {
        
        return "PersonalInfo{" +
                "age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", gender='" + gender + '\'' +
                ", exerciseLevelId=" + exerciseLevelId +
                ", calorieFormula='" + calorieFormula + '\'' +
                ", bodyFat=" + bodyFat +
                '}';
    }

    @Override
    public void setAge(int age) {
       this.age = age;
    }

    @Override
    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setExerciseLevelId(int exerciseLevelId) {
        this.exerciseLevelId = exerciseLevelId;
    }

    @Override
    public void setCalorieFormula(String calorieFormula) {
        this.calorieFormula = calorieFormula;
    }

    @Override
    public void setBodyFat(double bodyFat) {
        this.bodyFat = bodyFat;
    }
}
