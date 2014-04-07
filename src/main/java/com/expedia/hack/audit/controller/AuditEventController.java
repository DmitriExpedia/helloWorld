/**
 *
 * AuditEventController.java
 *
 * Copyright 2014 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.hack.audit.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.expedia.hack.DocumentLink;
import com.expedia.hack.RssEntry;
import com.expedia.hack.RssLine;
import com.expedia.hack.Utilities;
import com.expedia.hack.audit.AuditEvent;
import com.expedia.hack.repository.AuditEventRepository;

/**
 * TODO v-dmelnikov Describe AuditEventController
 * 
 * @author <a href="mailto:v-dmelnikov@expedia.com">v-dmelnikov</a>
 * 
 */
@Controller
@RequestMapping(value = "/polaris/audit")
public class AuditEventController {
    @Autowired
    private AuditEventRepository auditEventRepository;

    @RequestMapping(value = "rss/adminAuditEvents.do")
    public final ModelAndView auditEvents(HttpServletRequest request, HttpServletResponse response) {

        Date start = new Date(new Date().getTime() - 12 * 60 * 60 * 1000);
        List<AuditEvent> events = auditEventRepository.findAuditEvents(start);

        RssLine line = constructRssLine(events, request);
        line.setTitle("Polaris Admin Tools Audit Events");

        ModelAndView modelandView = new ModelAndView();
        modelandView.addObject("rssLine", line);
        modelandView.setViewName("rssDocument");
        return modelandView;

    }

    @RequestMapping(value = "/{auditID}/{creationDate}/details.do")
    public final ModelAndView vmOverflowWarning(@PathVariable
    Long auditID, @PathVariable
    Long creationDate, HttpServletRequest request, HttpServletResponse response) {

        Date startDate = new Date(creationDate - 60 * 1000);
        Date endDate = new Date(creationDate + 60 * 1000);
        AuditEvent event = auditEventRepository.findVMActionDetails(auditID, startDate, endDate);

        ModelAndView modelandView = new ModelAndView();
        modelandView.addObject("event", event);
        modelandView.setViewName("audit/auditDetails");
        return modelandView;

    }

    private RssLine constructRssLine(List<AuditEvent> events, HttpServletRequest request) {
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

        if (!events.isEmpty()) {
            String serverURL = Utilities.getServerURL(request);
            for (AuditEvent event : events) {
                RssEntry entry = new RssEntry();
                String uniqueID = serverURL + "/polaris/audit/" + event.getAuditID() + "/"
                        + event.getCreationDate().getTime() + "/details.do";
                String creationDate = Utilities.DATE_FORMAT.get().format(event.getCreationDate());

                entry.setId(uniqueID);
                entry.setPublished(creationDate);

                StringBuffer title = new StringBuffer();
                title.append("Config ").append(event.getPath()).append("  property - ").append(event.getPropertyName())
                        .append(" was changed in admin tools to be ").append(event.getNewValue());
                ;
                entry.setTitle(title.toString());
                entry.setUpdated(creationDate);
                // entry.setDescription();
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
