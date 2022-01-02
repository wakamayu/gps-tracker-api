/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wakamayu.jucu.gps.tracker.api.healthcheck;

import com.wakamayu.jucu.health.check.injector.annotate.HealthCheck;
import com.wakamayu.jucu.health.check.injector.enums.TypeConfig;

/**
 *
 * @author carlos
 */
@HealthCheck(fileConfig = "/META-INF/healthcheck-config.properties" , typeConfig = TypeConfig.PROPERTIES )
public interface ProviderHealthCheck {
    
}
