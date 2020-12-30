/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darren.fitnesscalculator.idealweight;

import javax.ejb.Stateful;

/**
 *
 * @author Darren
 */
@Stateful
public class IdealWeight implements IdealWeightRemote {

    private static final String MALE = "male";
    private static final String FEMALE = "female";
    
    @Override
    public double calculateIdealWeight(double height, String gender) {
        double counter = 0;
        if(gender.equalsIgnoreCase(MALE)){
            counter = 21.5;
        }
        else if(gender.equalsIgnoreCase(FEMALE)){
            counter = 23;
        }
        return Math.pow(height, 2) * counter;
    }
}
