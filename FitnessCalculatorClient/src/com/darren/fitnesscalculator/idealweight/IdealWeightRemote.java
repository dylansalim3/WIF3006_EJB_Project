/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darren.fitnesscalculator.idealweight;

import javax.ejb.Remote;

/**
 *
 * @author Darren
 */
@Remote
public interface IdealWeightRemote {
    double calculateIdealWeight(double height, String gender);
}
