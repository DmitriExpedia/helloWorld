/**
 * Utility class. Contains utility methods.
 * 
 * Utilities.java
 *
 * Copyright 2014 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.hack;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

/**
 * TODO v-dmelnikov Describe Utilities
 * 
 * @author <a href="mailto:v-dmelnikov@expedia.com">v-dmelnikov</a>
 * 
 */
public class Utilities {
    public static ThreadLocal<DateFormat> DATE_FORMAT = new ThreadLocal<DateFormat>()
        {
            @Override
            protected SimpleDateFormat initialValue() {
                SimpleDateFormat dsf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
                return dsf;

            }
        };

    public static String getServerURL(HttpServletRequest request) {
        String servletPath = request.getServletPath();
        String requestURL = request.getRequestURL().toString();

        Integer sPathIndex = requestURL.indexOf(servletPath);
        return requestURL.substring(0, sPathIndex);
    }
}
