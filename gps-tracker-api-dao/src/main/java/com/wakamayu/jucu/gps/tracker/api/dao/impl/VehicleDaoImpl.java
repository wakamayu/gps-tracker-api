/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wakamayu.jucu.gps.tracker.api.dao.impl;

import com.wakamayu.jucu.gps.tracker.api.dao.*;
import com.wakamayu.jucu.gps.tracker.api.model.Vehicle;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author carlos
 */
@Stateless
public class VehicleDaoImpl implements VehicleDao {

    @PersistenceContext(name = "gpspu")
    EntityManager em;

    @Override
    public void create(Vehicle vehicle) {
        em.persist(vehicle);
    }

    @Override
    public List<Vehicle> all() {
        return em.createNativeQuery("SELECT * FROM vehicle", Vehicle.class).getResultList();
    }

    @Override
    public List<Vehicle> all(Vehicle vehicle) {
        Query query = em.createNativeQuery("SELECT * FROM vehicle WHERE plate_number = ?plate_number", Vehicle.class);
        query.setParameter("plate_number", vehicle.getPlateNumber());
        return query.getResultList();
    }

}
