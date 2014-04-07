/**
 * 
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
import com.expedia.hack.vm.NackedPartnerHistory;

/**
 * @author v-sdalzhanok
 *
 */
@Controller
@RequestMapping(value = "/polaris/vmhistory/details")
public class NackedPartnerDetailsWebController {
	
	@Autowired
	private VMRepository vmRepository;
	
	@RequestMapping(value = "/{partnerId}/{actionTime}/details.do")
	public final ModelAndView vmOverflowWarning(@PathVariable
	Integer partnerId, @PathVariable
	Long actionTime, HttpServletRequest request, HttpServletResponse response) {
	
	    Date date = new Date(actionTime);
	    List<NackedPartnerHistory> historyRecords = vmRepository.findVMNackedPartnersDetailsRecords(date, partnerId);
	    ModelAndView modelandView = new ModelAndView();
	    modelandView.addObject("historyRecords", historyRecords);
	    modelandView.addObject("partnerName", historyRecords.get(0).getBusinessName());
	    modelandView.setViewName("nackedPartnerDetailsDocument");
	    return modelandView;	
	}
}
