/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darren.fitnesscalculator.calorie;

import javax.ejb.Stateful;


/**
 *
 * @author Darren
 */
@Stateful
public class CalorieCalculation implements CalorieCalculationRemote {
    
 
    
    private static final String MALE = "male";
    private static final String FEMALE = "female";

    private static final int ONE_KG_CALORIES = 7700;
    private static final int ONE_KG_CALORIES_PER_WEEK = ONE_KG_CALORIES / 7;
    private static final int HALF_KG_CALORIES_PER_WEEK = ONE_KG_CALORIES_PER_WEEK / 2;
    private static final int QUARTER_KG_CALORIES_PER_WEEK = HALF_KG_CALORIES_PER_WEEK / 2;
    
    public static final String MIFFIN_ST_JEOR = "Mifflin-St Jeor Equation";
    public static final String REVISED_HARRIS_BENEDICT = "Revised Harris-Benedict Equation";
    public static final String KATCH_MCARDLE = "Katch-McArdle Formula";
    
    public static final String[] CALORIE_FORMULA_LIST = new String[]{MIFFIN_ST_JEOR, REVISED_HARRIS_BENEDICT, KATCH_MCARDLE};
    
    private int caloriesToMaintain;
    private int caloriesToMildWeightLoss;
    private int caloriesToWeightLoss;
    private int caloriesToExtremeWeightLoss;
    
    @Override
    public void calculateCalorieLevel(String gender, double weight, double height, int age, double bodyFat,String calorieFormula, double counter){
            
            double bmr = 0;
            
            switch(calorieFormula){
                case MIFFIN_ST_JEOR:
                    bmr = calMiffin(weight, height, age, gender);
                    break;
                case REVISED_HARRIS_BENEDICT:
                    bmr = calHarris(weight, height, age, gender);
                    break;
                case KATCH_MCARDLE:
                    bmr = calKatch(weight, bodyFat);
                    break;
                default:
            }
            int dailyCaloriesRequired = (int) Math.round(calDailyCaloriesRequired(bmr, counter));
            createResult(dailyCaloriesRequired);
     
    }
    
    private double calMiffin(double weight, double height, int age, String gender) {
        double general = (10 * weight) + (6.25 * height) - (5 * age);
        if (gender.equalsIgnoreCase(MALE)) {
            return general + 5;
        } else if (gender.equalsIgnoreCase(FEMALE)) {
            return general + 161;
        } else {
            return -1;
        }
    }
    
    private double calHarris(double weight, double height, int age, String gender) {
        if (gender.equalsIgnoreCase(MALE)) {
            return (13.397 * weight) + (4.799 * height) - (5.677 * age) + 88.362;
        } else if (gender.equalsIgnoreCase(FEMALE)) {
            return (9.247 * weight) + (3.098 * height) - (4.330 * age) + 447.593;
        } else {
            return -1;
        }
    }
    
    private double calKatch(double weight, double fat) {
        return 370 + (21.6 * (1 - fat) * weight);
    }
     
    private double calDailyCaloriesRequired(double bmi, double counter) {
        return bmi * counter;
    }
    
    private void createResult(int dailyCaloriesRequired){
        caloriesToMaintain = dailyCaloriesRequired;
        caloriesToMildWeightLoss = (dailyCaloriesRequired - QUARTER_KG_CALORIES_PER_WEEK);
        caloriesToWeightLoss = (dailyCaloriesRequired - HALF_KG_CALORIES_PER_WEEK);
        caloriesToExtremeWeightLoss = (dailyCaloriesRequired - ONE_KG_CALORIES_PER_WEEK);
    }

    @Override
    public int getCaloriesToMaintain() {
        return caloriesToMaintain;
    }

    @Override
    public int getCaloriesToMildWeightLoss() {
        return caloriesToMildWeightLoss;
    }

    @Override
    public int getCaloriesToWeightLoss() {
        return caloriesToWeightLoss;
    }

    @Override
    public int getCaloriesToExtremeWeightLoss() {
        return caloriesToExtremeWeightLoss;
    }
    
    
    
}



