/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darren.fitnesscalculator.calorie;

import javax.ejb.Remote;

/**
 *
 * @author Darren
 */
@Remote
public interface CalorieCalculationRemote {
    void calculateCalorieLevel(String gender, double weight, double height, int age, double bodyFat,String calorieFormula, double counter);
    int getCaloriesToMaintain();
    int getCaloriesToMildWeightLoss();
    int getCaloriesToWeightLoss();
    int getCaloriesToExtremeWeightLoss();
}
