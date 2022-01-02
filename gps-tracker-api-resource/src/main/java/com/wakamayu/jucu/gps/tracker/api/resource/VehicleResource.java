package com.wakamayu.jucu.gps.tracker.api.resource;

import javax.inject.Singleton;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import com.wakamayu.jucu.gps.tracker.api.model.Vehicle;
import com.wakamayu.jucu.gps.tracker.api.service.VehicleService;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;

/**
 *
 */
@Path("/vehicle")
@Singleton
public class VehicleResource {

    @Inject
    VehicleService vehicleService;

    @POST
    public Response create(Vehicle vehicle) {
        try {
            vehicleService.create(vehicle);
            return Response.ok().build();
        } catch (Exception e) {
            System.out.println(e);
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/all")
    public Response all(@QueryParam("plate_number") String plateNumber) {
        try {
            List<Vehicle> listVehicle = new ArrayList();
            if (plateNumber != null && !plateNumber.isEmpty() && !plateNumber.isBlank()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setPlateNumber(plateNumber);
                listVehicle = vehicleService.all(vehicle);
            } else {
                listVehicle = vehicleService.all();
            }

            return Response.ok(listVehicle).build();
        } catch (Exception e) {
            System.out.println(e);
            return Response.serverError().build();
        }
    }

}
