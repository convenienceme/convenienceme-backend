package me.convenience.api.controller;

import javax.validation.Valid;

import me.convenience.api.model.Credentials;
import me.convenience.api.model.Status;

import org.apache.log4j.Logger;
import org.springframework.mvc.extensions.ajax.AjaxUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/**
 * 
 * @author jsreevalsan
 *
 */
@Controller
@RequestMapping("/form") 
public class FormController {
	

	Logger log = Logger.getLogger("me.convenience.api.controller.FormController"); 


	// Invoked on every request

	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}

	// Invoked initially to create the "form" attribute
	// Once created the "form" attribute comes from the HTTP session (see @SessionAttributes)

	@ModelAttribute("credentials")
	public Credentials createFormBean() {
		return new Credentials();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void form() {
	}

	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Status processSubmit(@Valid Credentials credentials, BindingResult result, 
								@ModelAttribute("ajaxRequest") boolean ajaxRequest, 
								Model model, RedirectAttributes redirectAttrs) {
		if (result.hasErrors()) {
			return null;
		}
		
		log.info("Login " + credentials.getUserName()) ;
 
		Status s = new Status() ;
		
		if(credentials.getUserName().equalsIgnoreCase("bb@ben")){
			s.setStatusCd("1") ; 
			s.setStatusDesc("Success");
		}else{
			s.setStatusCd("0") ; 
			s.setStatusDesc("User Name / Password incorrect. Please try again.");
		}
		
		return s;
 
	}
	
}
