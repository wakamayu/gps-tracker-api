/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wakamayu.jucu.gps.tracker.api.dao.impl;

import com.wakamayu.jucu.gps.tracker.api.dao.*;
import com.wakamayu.jucu.gps.tracker.api.model.Trip;
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
public class TripDaoImpl implements TripDao {

    @PersistenceContext(name = "gpspu")
    EntityManager em;

    @Override
    public Trip create(Trip trip) {
        em.persist(trip);
        return trip;
    }

    @Override
    public List<Trip> all() {
        return em.createNativeQuery("SELECT * FROM trip", Trip.class).getResultList();
    }

    @Override
    public List<Trip> all(Trip trip) {
        Query query = em.createNativeQuery("SELECT * FROM trip WHERE id = ?id", Trip.class);
        query.setParameter("id", trip.getId());
        return query.getResultList();
    }


}
