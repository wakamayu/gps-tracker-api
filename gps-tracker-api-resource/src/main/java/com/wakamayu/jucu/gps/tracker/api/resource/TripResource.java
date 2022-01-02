/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wakamayu.jucu.gps.tracker.api.resource;

import com.wakamayu.jucu.gps.tracker.api.model.Trip;
import com.wakamayu.jucu.gps.tracker.api.service.TripService;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author carlos
 */
@Path("/trip")
@Singleton
public class TripResource {

    @Inject
    TripService tripService;

    @POST
    public Response create(Trip trip) {
        try {
            Trip result = tripService.create(trip);
            return Response.ok(result).build();
        } catch (Exception e) {
            System.out.println(e);
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/all")
    public Response all() {
        try {
            List<Trip> listTrip = new ArrayList();

            listTrip = tripService.all();

            return Response.ok(listTrip).build();

        } catch (Exception e) {
            System.out.println(e);
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/id/{id}")
    public Response all(@PathParam("id") Integer id) {
        try {
            List<Trip> listTrip = tripService.all(new Trip(id));
            Trip trip = new Trip();
            if (!listTrip.isEmpty()) {
                trip = listTrip.get(0);
            }
            return Response.ok(trip).build();

        } catch (Exception e) {
            System.out.println(e);
            return Response.serverError().build();
        }
    }
}
