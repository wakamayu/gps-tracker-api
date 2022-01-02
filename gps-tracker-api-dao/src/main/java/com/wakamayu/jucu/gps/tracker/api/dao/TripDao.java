/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wakamayu.jucu.gps.tracker.api.dao;

import com.wakamayu.jucu.gps.tracker.api.model.Trip;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface TripDao {

    public Trip create(Trip trip);

    public List<Trip> all();


    public List<Trip> all(Trip trip);
}
