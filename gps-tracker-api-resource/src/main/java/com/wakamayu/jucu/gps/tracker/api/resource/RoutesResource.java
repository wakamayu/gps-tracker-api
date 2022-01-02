/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wakamayu.jucu.gps.tracker.api.resource;

import com.wakamayu.jucu.gps.tracker.api.model.Route;
import com.wakamayu.jucu.gps.tracker.api.service.RoutesService;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author carlos
 */
@Path("/routes")
@Singleton
public class RoutesResource {

    @Inject
    RoutesService routesService;

    @POST
    public Response create(Route routes) {
        try {
            Route result = routesService.create(routes);
            return Response.ok(result).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

}
