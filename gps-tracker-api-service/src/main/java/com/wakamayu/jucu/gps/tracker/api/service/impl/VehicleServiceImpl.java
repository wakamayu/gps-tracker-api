/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wakamayu.jucu.gps.tracker.api.service.impl;

import com.wakamayu.jucu.gps.tracker.api.dao.VehicleDao;
import com.wakamayu.jucu.gps.tracker.api.model.Vehicle;
import com.wakamayu.jucu.gps.tracker.api.service.VehicleService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author carlos
 */
@Stateless
public class VehicleServiceImpl implements VehicleService {

    @Inject
    private VehicleDao dao;

    @Override
    public void create(Vehicle vehicle) {
        dao.create(vehicle);
    }

    @Override
    public List<Vehicle> all() {
        return dao.all();
    }

    @Override
    public List<Vehicle> all(Vehicle vehicle) {
        return dao.all(vehicle);
    }

}
