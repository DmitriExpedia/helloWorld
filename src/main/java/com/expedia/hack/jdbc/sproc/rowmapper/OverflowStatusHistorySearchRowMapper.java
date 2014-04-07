/**
 *
 * OverflowStatusHistorySearchRowMapper.java
 *
 * Copyright 2014 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.hack.jdbc.sproc.rowmapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.expedia.hack.vm.OverflowHistory;

/**
 * TODO v-dmelnikov Describe OverflowStatusHistorySearchRowMapper
 * 
 * @author <a href="mailto:v-dmelnikov@expedia.com">v-dmelnikov</a>
 * 
 */
public class OverflowStatusHistorySearchRowMapper {
    private final static String SILO_ID = "SiloID";
    private final static String IP_ADDRESS = "IPAddress";

    private final static String HISTORY_CREATION_DATE = "OverflowStatusHistoryCreationD";
    private final static String STATUS_ID = "OverflowStatusID";
    private final static String STATUS_CODE = "OverflowStatusCode";
    private final static String QUEUE_ID = "QueueID";
    private final static String QUEUE_NAME = "QueueName";

    private final static String OVERFLOW_VALUE = "OverflowValue";
    private final static String LOW_THRESHOLD = "LowThresholD";
    private final static String WARNING_THRESHOLD = "WarningThresholD";
    private final static String CRITICAL_THRESHOLD = "CriticalThresholD";
    private final static String MAX_QUEUE = "MaxQueue";

    private final static String INET_DRIVER_RESULT_SET_1_RESULT_NAME = "#result-set-1";

    public List<OverflowHistory> mapSprocResult(Map<String, Object> rawResponse) {
        List<OverflowHistory> historyRecords = null;

        if (rawResponse != null && !rawResponse.isEmpty()) {
            List<Map<String, Object>> resultSet = (List<Map<String, Object>>) rawResponse
                    .get(INET_DRIVER_RESULT_SET_1_RESULT_NAME);

            if (resultSet != null) {
                historyRecords = new ArrayList<OverflowHistory>(resultSet.size());

                for (Map<String, Object> row : resultSet) {
                    OverflowHistory history = new OverflowHistory();
                    history.setCriticalThreshold((Integer) row.get(CRITICAL_THRESHOLD));
                    history.setLowThreshold((Integer) row.get(LOW_THRESHOLD));
                    history.setWarningThreshold((Integer) row.get(WARNING_THRESHOLD));
                    history.setIpAddress((String) row.get(IP_ADDRESS));
                    history.setSiloID((Integer) row.get(SILO_ID));
                    history.setMaxQueue((Integer) row.get(MAX_QUEUE));
                    history.setStatusCode((String) row.get(STATUS_CODE));
                    history.setStatusID((Integer) row.get(STATUS_ID));
                    history.setQueueName((String) row.get(QUEUE_NAME));
                    history.setQueueID((Integer) row.get(QUEUE_ID));
                    history.setOverflowValue((Integer) row.get(OVERFLOW_VALUE));
                    history.setCreationDate((Date) row.get(HISTORY_CREATION_DATE));
                    historyRecords.add(history);
                }

            }
        }

        return historyRecords;
    }
}
