/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wakamayu.jucu.gps.tracker.api.resource;

import com.wakamayu.jucu.gps.tracker.api.model.ReferralGuide;
import com.wakamayu.jucu.gps.tracker.api.model.Trip;
import com.wakamayu.jucu.gps.tracker.api.service.ReferralGuideService;
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
@Path("/referral-guide")
@Singleton
public class ReferralGuideResource {

    @Inject
    ReferralGuideService referralGuideService;

    @POST
    public Response create(ReferralGuide referralGuide) {
        try {
            ReferralGuide guide = referralGuideService.create(referralGuide);
            return Response.ok(guide).build();
        } catch (Exception e) {
            System.out.println(e);
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/all")
    public Response all(@QueryParam("idTrip") Integer idTrip) {
        try {
            List<ReferralGuide> listReferralGuide = new ArrayList();
            if (idTrip != null && idTrip > 0) {
                ReferralGuide referralGuide = new ReferralGuide();
                referralGuide.setIdTrip(new Trip(idTrip));

                listReferralGuide = referralGuideService.all(referralGuide);
            } else {

                listReferralGuide = referralGuideService.all();
            }
            return Response.ok(listReferralGuide).build();
        } catch (Exception e) {
            System.out.println(e);
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/id-number-guide/{id-number-guide}")
    public Response findById(@PathParam("id-number-guide") String idNumberGuide) {
        try {
            ReferralGuide guide = new ReferralGuide();
            guide.setNumberGuide(idNumberGuide);
            ReferralGuide referralGuide = referralGuideService.findById(guide);

            return Response.ok(referralGuide).build();
        } catch (Exception e) {
            System.out.println(e);
            return Response.serverError().build();
        }
    }

}
