/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wakamayu.jucu.gps.tracker.api.service;

import com.wakamayu.jucu.gps.tracker.api.model.ReferralGuide;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface ReferralGuideService {

    public ReferralGuide create(ReferralGuide referralGuide);

    public List<ReferralGuide> all();

    public List<ReferralGuide> all(ReferralGuide referralGuide);

    public ReferralGuide findById(ReferralGuide referralGuide);
}
