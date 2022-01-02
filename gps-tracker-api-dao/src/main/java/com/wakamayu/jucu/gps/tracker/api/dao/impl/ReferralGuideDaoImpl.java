/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wakamayu.jucu.gps.tracker.api.dao.impl;

import com.wakamayu.jucu.gps.tracker.api.dao.*;
import com.wakamayu.jucu.gps.tracker.api.model.ReferralGuide;
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
public class ReferralGuideDaoImpl implements ReferralGuideDao {

    @PersistenceContext(name = "gpspu")
    EntityManager em;

    @Override
    public ReferralGuide create(ReferralGuide referralGuide) {
        em.persist(referralGuide);
        return referralGuide;
    }

    @Override
    public List<ReferralGuide> all() {
        return em.createNativeQuery("SELECT * FROM referral_guide", ReferralGuide.class).getResultList();
    }

    @Override
    public List<ReferralGuide> all(ReferralGuide referralGuide) {
        Query query = em.createNativeQuery("SELECT * FROM referral_guide WHERE id_trip = ?id_trip", ReferralGuide.class);
        query.setParameter("id_trip", referralGuide.getIdTrip().getId());
        return query.getResultList();
    }

    @Override
    public ReferralGuide findById(ReferralGuide referralGuide) {
        Query query = em.createNativeQuery("SELECT * FROM referral_guide WHERE number_guide = ?number_guide", ReferralGuide.class);
        query.setParameter("number_guide", referralGuide.getNumberGuide());
        ReferralGuide guide = new ReferralGuide();
        List<ReferralGuide> list = query.getResultList();
        if (!list.isEmpty()) {
            guide = list.get(0);
        }
        return guide;
    }

}
