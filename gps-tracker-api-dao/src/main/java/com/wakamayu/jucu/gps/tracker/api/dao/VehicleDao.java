/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wakamayu.jucu.gps.tracker.api.dao;

import com.wakamayu.jucu.gps.tracker.api.model.Vehicle;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface VehicleDao {

    public void create(Vehicle vehicle);

    public List<Vehicle> all();

    public List<Vehicle> all(Vehicle vehicle);
}
