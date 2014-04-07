/**
 *
 * Silo.java
 *
 * Copyright 2014 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.hack;

/**
 * Silo
 * 
 * @author <a href="mailto:v-dmelnikov@expedia.com">v-dmelnikov</a>
 * 
 */
public class Silo {
    private String ipAddress;
    private Integer id;

    /**
     * @param ipAddress
     * @param id
     */
    public Silo(String ipAddress, Integer id) {
        super();
        this.ipAddress = ipAddress;
        this.id = id;
    }

    /**
     * @return Returns the ipAddress.
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * @return Returns the id.
     */
    public Integer getId() {
        return id;
    }

}
