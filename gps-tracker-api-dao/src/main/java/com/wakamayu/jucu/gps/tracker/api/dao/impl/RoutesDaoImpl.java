/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wakamayu.jucu.gps.tracker.api.dao.impl;

import com.wakamayu.jucu.gps.tracker.api.dao.RoutesDao;
import com.wakamayu.jucu.gps.tracker.api.model.Route;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author carlos
 */
@Stateless
public class RoutesDaoImpl implements RoutesDao {

    @PersistenceContext(name = "gpspu")
    EntityManager em;

    @Override
    public Route create(Route routes) {
        em.persist(routes);
        return routes;
    }

}
