/**
 *
 * ParameterDataWebController.java
 *
 * Copyright 2013 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.hack.vm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.expedia.hack.DocumentLink;
import com.expedia.hack.RssEntry;
import com.expedia.hack.RssLine;
import com.expedia.hack.Utilities;
import com.expedia.hack.repository.VMRepository;
import com.expedia.hack.vm.NackedPartnerHistory;
import com.expedia.hack.vm.OverflowHistory;


/**
 * TODO v-dmelnikov Describe ParameterDataWebController
 * 
 * @author <a href="mailto:v-dmelnikov@expedia.com">v-dmelnikov</a>
 * 
 */
@Controller
@RequestMapping(value = "/polaris/rss")
public class OverflowRssWebController {
    
    @Autowired
    private VMRepository vmRepository;

    @RequestMapping(value = "vmOverflowWarning.do")
    public final ModelAndView vmOverflowWarning(HttpServletRequest request,
            HttpServletResponse response) {

        Date end = new Date(new Date().getTime() + 12 * 60 * 60 * 1000);
        Date start = new Date(new Date().getTime() - 12 * 60 * 60 * 1000);
        List<OverflowHistory> historyRecords = vmRepository.findVMRecords(start, end, "Warning");
        
        RssLine line = constructRssLine(historyRecords, request);
        line.setTitle("Polaris VM Warning");
        
        ModelAndView modelandView = new ModelAndView();
        modelandView.addObject("rssLine", line);
        modelandView.setViewName("rssDocument");
        return modelandView;

    }
    
    @RequestMapping(value = "vmOverflowCritical.do")
    public final ModelAndView vmOverflowCritical(HttpServletRequest request,
            HttpServletResponse response) {

        Date end = new Date(new Date().getTime() + 12 * 60 * 60 * 1000);
        Date start = new Date(new Date().getTime() - 12 * 60 * 60 * 1000);
        List<OverflowHistory> historyRecords = vmRepository.findVMRecords(start, end, "Critical");

        RssLine line = constructRssLine(historyRecords, request);
        line.setTitle("Polaris VM Critical");
        
        ModelAndView modelandView = new ModelAndView();
        modelandView.addObject("rssLine", line);
        modelandView.setViewName("rssDocument");
        return modelandView;
    }

    @RequestMapping(value = "partnerNacked.do")
    public final ModelAndView partnerOverflow(HttpServletRequest request, HttpServletResponse response) {
    	
    	Date end = new Date(new Date().getTime() + 12 * 60 * 60 * 1000);
        Date start = new Date(new Date().getTime() - 12 * 60 * 60 * 1000);
        List<NackedPartnerHistory> historyRecords = vmRepository.findVMNackedPartnersRecords(start, end);
        
        RssLine line = constructRssLineForNackedPartners(historyRecords, request);
        line.setTitle("Nacked partners by VM");
        
        ModelAndView modelandView = new ModelAndView();
        modelandView.addObject("rssLine", line);
        modelandView.setViewName("rssDocument");
        return modelandView;
    }    
    
    private RssLine constructRssLine(List<OverflowHistory> historyRecords, HttpServletRequest request) {
        RssLine line = new RssLine();
        line.setAuthorName("Polaris");
        line.setId(request.getRequestURL().toString());
        List rssEntries = new ArrayList();
        line.setEntries(rssEntries);
        line.setUpdated(Utilities.DATE_FORMAT.get().format(new Date()));
        DocumentLink link = new DocumentLink();
        link.setHref(request.getRequestURL().toString());
        link.setRel("alternate");
        link.setType("text/html");
        line.setLink(link);
        
        if (!historyRecords.isEmpty()) {
            String serverURL = Utilities.getServerURL(request);
            for (OverflowHistory history : historyRecords) {
                RssEntry entry = new RssEntry();
                String uniqueID = serverURL + "/polaris/overflow/details/" + history.getSiloID() + "/" + history.getCreationDate().getTime() + "/details.do";
                String creationDate = Utilities.DATE_FORMAT.get().format(history.getCreationDate());
                
                entry.setId(uniqueID);
                entry.setPublished(creationDate);

                StringBuffer title = new StringBuffer();
                title.append("VM status is ").append(history.getStatusCode()).append(" for queue ")
                        .append(history.getQueueName()).append(" on silo ")
                        .append(history.getIpAddress());
                entry.setTitle(title.toString());
                entry.setUpdated(creationDate);
                entry.setDescription("Queue size is " + history.getOverflowValue());
                DocumentLink historyLink = new DocumentLink();
                historyLink.setHref(uniqueID);
                historyLink.setRel("alternate");
                historyLink.setType("text/html");
                entry.setLink(historyLink);
                rssEntries.add(entry);
            }
        }
        
        return line;
    }
    
    private RssLine constructRssLineForNackedPartners(List<NackedPartnerHistory> historyRecords, HttpServletRequest request) {
        RssLine line = new RssLine();
        line.setAuthorName("Polaris");
        line.setId(request.getRequestURL().toString());
        List rssEntries = new ArrayList();
        line.setEntries(rssEntries);
        line.setUpdated(Utilities.DATE_FORMAT.get().format(new Date()));
        DocumentLink link = new DocumentLink();
        link.setHref(request.getRequestURL().toString());
        link.setRel("alternate");
        link.setType("text/html");
        line.setLink(link);
        
        if (!historyRecords.isEmpty()) {
            String serverURL = Utilities.getServerURL(request);
            for (NackedPartnerHistory history : historyRecords) {
                RssEntry entry = new RssEntry();
                String uniqueID = serverURL + "/polaris/vmhistory/details/" + history.getPartnerID() + "/" + history.getCreationDate().getTime() + "/details.do";
                String creationDate = Utilities.DATE_FORMAT.get().format(history.getCreationDate());
                
                entry.setId(uniqueID);
                entry.setPublished(creationDate);

                StringBuffer title = new StringBuffer();
                title.append("Partner ").append(history.getBusinessName()).append(" was nacked by VM ")
                        .append(" on silo ").append(history.getIpAddress());
                entry.setTitle(title.toString());
                entry.setUpdated(creationDate);
                DocumentLink historyLink = new DocumentLink();
                historyLink.setHref(uniqueID);
                historyLink.setRel("alternate");
                historyLink.setType("text/html");
                entry.setLink(historyLink);
                rssEntries.add(entry);
            }
        }
        
        return line;
    }
}
