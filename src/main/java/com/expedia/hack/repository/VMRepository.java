/**
 *
 * VMRepository.java
 *
 * Copyright 2014 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.hack.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.expedia.hack.Silo;
import com.expedia.hack.jdbc.sproc.NackedPartnerSearchSproc;
import com.expedia.hack.jdbc.sproc.OverflowStatusHistorySearchSproc;
import com.expedia.hack.jdbc.sproc.SiloLstSproc;
import com.expedia.hack.vm.NackedPartnerHistory;
import com.expedia.hack.vm.OverflowHistory;

/**
 * TODO v-dmelnikov Describe VMRepository
 * 
 * @author <a href="mailto:v-dmelnikov@expedia.com">v-dmelnikov</a>
 * 
 */
@Repository
public class VMRepository {
	@Autowired
    private SiloLstSproc siloLstSproc;

	@Autowired
    private OverflowStatusHistorySearchSproc overflowStatusHistorySearchSproc;
    @Autowired
    private NackedPartnerSearchSproc nackedPartnerSearchSproc;

    private String siloList;
    private Map<Integer, Silo> siloMap;

    @PostConstruct
    private void init() {
        List<Silo> silos = siloLstSproc.execute();
        siloMap = new HashMap<Integer, Silo>(silos.size());
        StringBuffer sb = new StringBuffer();
        for (Silo silo : silos) {
            sb.append(silo.getIpAddress()).append(',');
            siloMap.put(silo.getId(), silo);
        }
        siloList = sb.toString().substring(0, sb.length() - 1);
    }

    public List<OverflowHistory> findVMRecords(Date start, Date end, String statusCodeList) {

        List<OverflowHistory> unfilteredList = overflowStatusHistorySearchSproc.execute(start, end,
                siloList, statusCodeList);

        if (unfilteredList != null) {
            List<OverflowHistory> actualBrokenQueues = new ArrayList<OverflowHistory>();
            for (OverflowHistory history : unfilteredList) {
                if (history.getQueueID().equals(history.getMaxQueue())) {
                    actualBrokenQueues.add(history);
                }
            }

            Collections.sort(actualBrokenQueues);
            return actualBrokenQueues;
        }

        return Collections.EMPTY_LIST;
    }

    public List<OverflowHistory> findVMActionDetails(Date date, String statusCodeList,
            Integer siloId) {

        List<OverflowHistory> unfilteredList = overflowStatusHistorySearchSproc.execute(date, date,
                siloMap.get(siloId).getIpAddress(), statusCodeList);

        if (unfilteredList != null) {
            Collections.sort(unfilteredList);
            return unfilteredList;
        }

        return Collections.EMPTY_LIST;
    }
    
    public List<NackedPartnerHistory> findVMNackedPartnersRecords(Date start, Date end) {
    	
    	List<NackedPartnerHistory> unfilteredList = nackedPartnerSearchSproc.execute(start, end, siloList, null, 1, 1);
    	if (unfilteredList != null) {
            Collections.sort(unfilteredList);
            return unfilteredList;
        }
    	
    	return Collections.EMPTY_LIST;
    }
    
    public List<NackedPartnerHistory> findVMNackedPartnersDetailsRecords(Date date, Integer partnerId) {
    	
    	Date end = date;
    	Date start = new Date(date.getTime() - 24 * 60 * 60 * 1000);
    	List<NackedPartnerHistory> unfilteredList = nackedPartnerSearchSproc.execute(start, end, siloList, partnerId.toString(), 1, 1);
    	if (unfilteredList != null) {
            Collections.sort(unfilteredList);
            return unfilteredList;
        }
    	
    	return Collections.EMPTY_LIST;
    }
}
