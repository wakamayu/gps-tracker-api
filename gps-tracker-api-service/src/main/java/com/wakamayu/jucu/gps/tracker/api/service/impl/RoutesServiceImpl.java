/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wakamayu.jucu.gps.tracker.api.service.impl;

import com.wakamayu.jucu.gps.tracker.api.dao.RoutesDao;
import com.wakamayu.jucu.gps.tracker.api.model.Route;
import com.wakamayu.jucu.gps.tracker.api.service.RoutesService;
import java.util.Calendar;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author carlos
 */
@Stateless
public class RoutesServiceImpl implements RoutesService {
    
    @Inject
    RoutesDao dao;
    
    @Override
    public Route create(Route routes) {
        routes.setDateCreate(Calendar.getInstance().getTime());
        return dao.create(routes);
    }
    
}
