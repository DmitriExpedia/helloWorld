/**
 *
 * AuditEvent.java
 *
 * Copyright 2014 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.hack.audit;

import java.util.Date;

/**
 * TODO v-dmelnikov Describe AuditEvent
 * 
 * @author <a href="mailto:v-dmelnikov@expedia.com">v-dmelnikov</a>
 * 
 */
public class AuditEvent implements Comparable<AuditEvent>{

    private String originatorIP;
    private String creationUser;
    private Date creationDate;
    private Long auditID;
    private String type;
    private String propertyName;
    private String path;
    private String oldValue;
    private String newValue;

    /**
     * @return Returns the originatorIP.
     */
    public String getOriginatorIP() {
        return originatorIP;
    }

    /**
     * @param originatorIP
     *            The originatorIP to set.
     */
    public void setOriginatorIP(String originatorIP) {
        this.originatorIP = originatorIP;
    }

    /**
     * @return Returns the creationUser.
     */
    public String getCreationUser() {
        return creationUser;
    }

    /**
     * @param creationUser
     *            The creationUser to set.
     */
    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    /**
     * @return Returns the creationDate.
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate
     *            The creationDate to set.
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return Returns the auditID.
     */
    public Long getAuditID() {
        return auditID;
    }

    /**
     * @param auditID
     *            The auditID to set.
     */
    public void setAuditID(Long auditID) {
        this.auditID = auditID;
    }

    /**
     * @return Returns the type.
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     *            The type to set.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return Returns the propertyName.
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * @param propertyName
     *            The propertyName to set.
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    /**
     * @return Returns the path.
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path
     *            The path to set.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return Returns the oldValue.
     */
    public String getOldValue() {
        return oldValue;
    }

    /**
     * @param oldValue
     *            The oldValue to set.
     */
    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    /**
     * @return Returns the newValue.
     */
    public String getNewValue() {
        return newValue;
    }

    /**
     * @param newValue
     *            The newValue to set.
     */
    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    @Override
    public int compareTo(AuditEvent other) {
        return creationDate.compareTo(other.getCreationDate());
    }

}
