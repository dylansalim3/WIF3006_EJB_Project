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
public class ExerciseLevel implements ExerciseLevelRemote {
    private int id;
    private String exerciseLevel;
    private double counter;
    
     @Override
    public int getId() {
        return id;
    }

    @Override
    public String getExerciseLevel() {
        return exerciseLevel;
    }

    @Override
    public double getCounter() {
        return counter;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setExerciseLevel(String exerciseLevel) {
        this.exerciseLevel = exerciseLevel;
    }

    @Override
    public void setCounter(double counter) {
        this.counter = counter;
    }
}
