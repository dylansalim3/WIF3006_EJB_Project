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
public interface ExerciseLevelRemote {
    int getId();
    String getExerciseLevel();
    double getCounter();
    
    void setId(int id);
    void setExerciseLevel(String exerciseLevel);
    void setCounter(double counter);
}
