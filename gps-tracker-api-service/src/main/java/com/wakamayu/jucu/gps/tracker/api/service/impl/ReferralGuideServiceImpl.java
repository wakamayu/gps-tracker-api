/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wakamayu.jucu.gps.tracker.api.service.impl;

import com.wakamayu.jucu.gps.tracker.api.dao.ReferralGuideDao;
import com.wakamayu.jucu.gps.tracker.api.model.ReferralGuide;
import com.wakamayu.jucu.gps.tracker.api.service.ReferralGuideService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author carlos
 */
@Stateless
public class ReferralGuideServiceImpl implements ReferralGuideService {

    @Inject
    ReferralGuideDao dao;

    @Override
    public ReferralGuide create(ReferralGuide referralGuide) {
        return dao.create(referralGuide);
    }

    @Override
    public List<ReferralGuide> all() {
        return dao.all();
    }

    @Override
    public List<ReferralGuide> all(ReferralGuide referralGuide) {
        return dao.all(referralGuide);
    }

    @Override
    public ReferralGuide findById(ReferralGuide referralGuide) {
     
        return dao.findById(referralGuide);
    }

}
