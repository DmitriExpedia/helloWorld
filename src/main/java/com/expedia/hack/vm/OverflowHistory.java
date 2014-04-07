/**
 *
 * OverflowHistory.java
 *
 * Copyright 2014 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.hack.vm;

import java.util.Date;

/**
 * TODO v-dmelnikov Describe OverflowHistory
 * 
 * @author <a href="mailto:v-dmelnikov@expedia.com">v-dmelnikov</a>
 * 
 */
public class OverflowHistory implements Comparable<OverflowHistory>{
    private String queueName;
    private String ipAddress;
    private Integer siloID;
    private Date creationDate;
    private Integer queueID;

    private Integer statusID;
    private String statusCode;

    private Integer lowThreshold;
    private Integer warningThreshold;
    private Integer criticalThreshold;

    private Integer overflowValue;
    private Integer maxQueue;

    /**
     * @return Returns the statusID.
     */
    public Integer getStatusID() {
        return statusID;
    }

    /**
     * @param statusID
     *            The statusID to set.
     */
    public void setStatusID(Integer statusID) {
        this.statusID = statusID;
    }

    /**
     * @return Returns the statusCode.
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * @param statusCode
     *            The statusCode to set.
     */
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * @return Returns the lowThreshold.
     */
    public Integer getLowThreshold() {
        return lowThreshold;
    }

    /**
     * @param lowThreshold
     *            The lowThreshold to set.
     */
    public void setLowThreshold(Integer lowThreshold) {
        this.lowThreshold = lowThreshold;
    }

    /**
     * @return Returns the warningThreshold.
     */
    public Integer getWarningThreshold() {
        return warningThreshold;
    }

    /**
     * @param warningThreshold
     *            The warningThreshold to set.
     */
    public void setWarningThreshold(Integer warningThreshold) {
        this.warningThreshold = warningThreshold;
    }

    /**
     * @return Returns the criticalThreshold.
     */
    public Integer getCriticalThreshold() {
        return criticalThreshold;
    }

    /**
     * @param criticalThreshold
     *            The criticalThreshold to set.
     */
    public void setCriticalThreshold(Integer criticalThreshold) {
        this.criticalThreshold = criticalThreshold;
    }

    /**
     * @return Returns the overflowValue.
     */
    public Integer getOverflowValue() {
        return overflowValue;
    }

    /**
     * @param overflowValue
     *            The overflowValue to set.
     */
    public void setOverflowValue(Integer overflowValue) {
        this.overflowValue = overflowValue;
    }

    /**
     * @return Returns the maxQueue.
     */
    public Integer getMaxQueue() {
        return maxQueue;
    }

    /**
     * @param maxQueue
     *            The maxQueue to set.
     */
    public void setMaxQueue(Integer maxQueue) {
        this.maxQueue = maxQueue;
    }

    /**
     * @return Returns the queueID.
     */
    public Integer getQueueID() {
        return queueID;
    }

    /**
     * @param queueID
     *            The queueID to set.
     */
    public void setQueueID(Integer queueID) {
        this.queueID = queueID;
    }

    /**
     * @return Returns the queueName.
     */
    public String getQueueName() {
        return queueName;
    }

    /**
     * @param queeuName
     *            The queeuName to set.
     */
    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    /**
     * @return Returns the ipAddress.
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * @param ipAddress
     *            The ipAddress to set.
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * @return Returns the siloID.
     */
    public Integer getSiloID() {
        return siloID;
    }

    /**
     * @param siloID
     *            The siloID to set.
     */
    public void setSiloID(Integer siloID) {
        this.siloID = siloID;
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

    @Override
    public int compareTo(OverflowHistory other) {
        return creationDate.compareTo(other.getCreationDate());
    }

}
