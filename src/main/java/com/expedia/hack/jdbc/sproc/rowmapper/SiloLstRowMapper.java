/**
 *
 * SiloLstRowMapper.java
 *
 * Copyright 2014 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.expedia.hack.jdbc.sproc.rowmapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.expedia.hack.Silo;

/**
 * TODO v-dmelnikov Describe SiloLstRowMapper
 * 
 * @author <a href="mailto:v-dmelnikov@expedia.com">v-dmelnikov</a>
 *
 */
public class SiloLstRowMapper {
    private final static String SILO_ID = "SiloID";
    private final static String IP_ADDRESS = "IPAddress";
    private final static String INET_DRIVER_RESULT_SET_1_RESULT_NAME = "#result-set-1";

   
    
    public List<Silo> mapSprocResult(Map<String, Object> rawResponse) {
        List<Silo> silos = null;
        
        if (rawResponse != null && !rawResponse.isEmpty()) {
            List<Map<String, Object>> resultSet = (List<Map<String, Object>>) rawResponse
                    .get(INET_DRIVER_RESULT_SET_1_RESULT_NAME);
                        
            if (resultSet != null) {
                silos = new ArrayList<Silo>(resultSet.size());
                
                for (Map<String, Object> row : resultSet) {
                    String ipAddress = (String) row.get(IP_ADDRESS);
                    Integer id = (Integer) row.get(SILO_ID);
                    silos.add(new Silo(ipAddress, id));
                }
                
            }
        } 
        
        if (silos != null) {
            return silos;
        } else {
            throw new IllegalStateException("No silos found in DB"); 
        }
    }
}
