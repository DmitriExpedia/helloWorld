/**
 *
 * AuditEventRepository.java
 *
 * Copyright 2014 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.hack.repository;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.expedia.hack.audit.AuditEvent;
import com.expedia.hack.jdbc.sproc.AuditEventSearchLstSproc;

/**
 * AuditEventRepository
 * 
 * @author <a href="mailto:v-dmelnikov@expedia.com">v-dmelnikov</a>
 * 
 */
@Repository
public class AuditEventRepository {

    @Autowired
    private AuditEventSearchLstSproc auditEventSproc;

    public List<AuditEvent> findAuditEvents(Date start) {
        List<AuditEvent> events = auditEventSproc.execute(start, null);
        if (events != null) {
            Collections.sort(events);
            return events;
        }

        return Collections.EMPTY_LIST;
    }

    public AuditEvent findVMActionDetails(Long auditID, Date start, Date end) {

        List<AuditEvent> events = auditEventSproc.execute(start, end);

        if (events != null) {
            for (AuditEvent event : events) {
                if (event.getAuditID().equals(auditID)) {
                    return event;
                }
            }
        }

        return null;
    }

}
