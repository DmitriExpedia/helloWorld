/**
 *
 * AuditEventSearchLstRowMapper.java
 *
 * Copyright 2014 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.expedia.hack.jdbc.sproc.rowmapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.expedia.hack.audit.AuditEvent;

/**
 * AuditEventSearchLstRowMapper
 * 
 * @author <a href="mailto:v-dmelnikov@expedia.com">v-dmelnikov</a>
 *
 */
public class AuditEventSearchLstRowMapper {
    private final static String ORIGINATOR_IP = "OriginatorIP";
    private final static String CREATION_USER = "EventCreationUser";
    private final static String CREATION_DATE = "EventCreationDate";
    private final static String AUDIT_ID = "AuditChangeID";
    private final static String EVENT_TYPE = "Nature";
    private final static String PROPERTY_NAME = "PropertyName";
    private final static String EVENT_PATH = "EventPath";
    private final static String OLD_VALUE = "OldValue";
    private final static String NEW_VALUE = "NewValue";

    private final static String INET_DRIVER_RESULT_SET_1_RESULT_NAME = "#result-set-1";

    public List<AuditEvent> mapSprocResult(Map<String, Object> rawResponse) {
        List<AuditEvent> auditEvents = null;

        if (rawResponse != null && !rawResponse.isEmpty()) {
            List<Map<String, Object>> resultSet = (List<Map<String, Object>>) rawResponse
                    .get(INET_DRIVER_RESULT_SET_1_RESULT_NAME);

            if (resultSet != null) {
                auditEvents = new ArrayList<AuditEvent>(resultSet.size());

                for (Map<String, Object> row : resultSet) {
                    AuditEvent event = new AuditEvent();
                    event.setAuditID(((BigDecimal) row.get(AUDIT_ID)).longValue());
                    event.setCreationDate((Date) row.get(CREATION_DATE));
                    event.setCreationUser((String) row.get(CREATION_USER));
                    event.setNewValue((String) row.get(NEW_VALUE));
                    event.setOldValue((String) row.get(OLD_VALUE));
                    event.setPath((String) row.get(EVENT_PATH));
                    event.setOriginatorIP((String) row.get(ORIGINATOR_IP));
                    event.setType((String) row.get(EVENT_TYPE));
                    event.setPropertyName((String) row.get(PROPERTY_NAME));
                    auditEvents.add(event);
                }
            }
        }

        return auditEvents;
    }
}
