package com.expedia.hack.vm;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author v-sdalzhanok
 *
 */
public class NackedPartnerHistory implements Comparable<NackedPartnerHistory>{
	private Date creationDate;
	private Integer coveredPeriod;
	private Integer siloID;
	private String ipAddress;
	private String partnerID;
	private String businessName;
	private Boolean isActive;
	private Boolean isNacked;
	private BigDecimal pctMessageIn;
	private BigDecimal pctUpdate;
	private BigDecimal pctOutFail;
	private BigDecimal pctOutResponseTime;
	private BigDecimal pctCapacityAllowed;
	
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getCoveredPeriod() {
		return coveredPeriod;
	}
	public void setCoveredPeriod(Integer coveredPeriod) {
		this.coveredPeriod = coveredPeriod;
	}
	public Integer getSiloID() {
		return siloID;
	}
	public void setSiloID(Integer siloID) {
		this.siloID = siloID;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getPartnerID() {
		return partnerID;
	}
	public void setPartnerID(String partnerID) {
		this.partnerID = partnerID;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Boolean getIsNacked() {
		return isNacked;
	}
	public void setIsNacked(Boolean isNacked) {
		this.isNacked = isNacked;
	}
	public BigDecimal getPctMessageIn() {
		return pctMessageIn;
	}
	public void setPctMessageIn(BigDecimal pctMessageIn) {
		this.pctMessageIn = pctMessageIn;
	}
	public BigDecimal getPctUpdate() {
		return pctUpdate;
	}
	public void setPctUpdate(BigDecimal pctUpdate) {
		this.pctUpdate = pctUpdate;
	}
	public BigDecimal getPctOutFail() {
		return pctOutFail;
	}
	public void setPctOutFail(BigDecimal pctOutFail) {
		this.pctOutFail = pctOutFail;
	}
	public BigDecimal getPctOutResponseTime() {
		return pctOutResponseTime;
	}
	public void setPctOutResponseTime(BigDecimal pctOutResponseTime) {
		this.pctOutResponseTime = pctOutResponseTime;
	}
	public BigDecimal getPctCapacityAllowed() {
		return pctCapacityAllowed;
	}
	public void setPctCapacityAllowed(BigDecimal pctCapacityAllowed) {
		this.pctCapacityAllowed = pctCapacityAllowed;
	}
	
	@Override
    public int compareTo(NackedPartnerHistory other) {
        return creationDate.compareTo(other.getCreationDate());
    }
}
