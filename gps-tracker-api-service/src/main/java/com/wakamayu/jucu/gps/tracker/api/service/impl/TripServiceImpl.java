/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wakamayu.jucu.gps.tracker.api.service.impl;

import com.wakamayu.jucu.gps.tracker.api.dao.TripDao;
import com.wakamayu.jucu.gps.tracker.api.model.Trip;
import com.wakamayu.jucu.gps.tracker.api.service.TripService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author carlos
 */
@Stateless
public class TripServiceImpl implements TripService {

    @Inject
    TripDao dao;

    @Override
    public Trip create(Trip trip) {
        return dao.create(trip);
    }

    @Override
    public List<Trip> all() {
        return dao.all();
    }

    @Override
    public List<Trip> all(Trip trip) {return dao.all(trip);}

}
