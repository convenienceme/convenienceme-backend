package me.convenience.api.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import me.convenience.api.model.Alert;
import me.convenience.api.model.Credentials;
import me.convenience.api.model.DashBoard;
import me.convenience.api.model.provider.AlertProvider;
import me.convenience.api.model.provider.DashboardProvider;
import me.convenience.api.model.provider.SubscriptionProvide;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mvc.extensions.ajax.AjaxUtils;
import org.springframework.samples.mvc.mapping.JavaBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.google.common.collect.Lists;

/**
 * 
 * @author jsreevalsan
 *
 */
@Controller
@RequestMapping("/dashboard") 
public class DashboardController {

	Logger log = Logger
			.getLogger("me.convenience.api.controller.DashboardController");

	// Invoked on every request

	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}

	// Invoked initially to create the "form" attribute
	// Once created the "form" attribute comes from the HTTP session (see
	// @SessionAttributes)

	@ModelAttribute("credentials")
	public Credentials createFormBean() {
		return new Credentials();
	}

	@Autowired private HttpServletRequest httpServletRequest;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody
	DashBoard processSubmit( @RequestParam("userid") String userId, Model model)  {
		
		
		log.info("User :" + userId);
		
		String context = getContextString(); 
		log.info("Context Request URL " + context);
		DashBoard d = new SubscriptionProvide().getDashboard(userId) ;
			//	new DashboardProvider().getDashboard(userId,context) ;

		return d;

	}

	
	@RequestMapping(value="/alerts", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Alert> byProducesAlerts() {
		
		AlertProvider ap = new AlertProvider() ;
		
		Alert r1 = new Alert();
		r1.setAlertId("100");
		r1.setAlertString("Super Alert");
		
		return ap.getAlerts();
	}
	
	private String getContextString() {
		 
		return httpServletRequest.getRequestURL().substring(0, 
				httpServletRequest.getRequestURL().indexOf(httpServletRequest.getContextPath())) 
				+ httpServletRequest.getContextPath();
	}
	
	 


}
