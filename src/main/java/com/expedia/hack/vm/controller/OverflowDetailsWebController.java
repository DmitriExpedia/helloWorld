/**
 *
 * OverflowDetailsWebController.java
 *
 * Copyright 2014 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.hack.vm.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.expedia.hack.repository.VMRepository;
import com.expedia.hack.vm.OverflowHistory;

/**
 * TODO v-dmelnikov Describe OverflowDetailsWebController
 * 
 * @author <a href="mailto:v-dmelnikov@expedia.com">v-dmelnikov</a>
 * 
 */
@Controller
@RequestMapping(value = "/polaris/overflow/details")
public class OverflowDetailsWebController {

    @Autowired
    private VMRepository vmRepository;

    @RequestMapping(value = "/{siloId}/{actionTime}/details.do")
    public final ModelAndView vmOverflowWarning(@PathVariable
    Integer siloId, @PathVariable
    Long actionTime, HttpServletRequest request, HttpServletResponse response) {

        Date date = new Date(actionTime);
        List<OverflowHistory> historyRecords = vmRepository.findVMActionDetails(date,
                "Warning,Critical", siloId);
        ModelAndView modelandView = new ModelAndView();
        modelandView.addObject("historyRecords", historyRecords);
        modelandView.setViewName("overflowDetailsDocument");
        return modelandView;

    }
}
