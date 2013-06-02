package me.convenience.api.controller;
 
import javax.validation.Valid;

import me.convenience.api.model.SMS;

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
@RequestMapping("/processSMS")
public class SMSProcessor {

	Logger log = Logger
			.getLogger("me.convenience.api.controller.SMSProcessor");

	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}
	

	@ModelAttribute("sms")
	public SMS createSMSBean() {
		return new SMS();
	}
	
	@RequestMapping(method = RequestMethod.POST,  produces="application/xml;charset=UTF-8")
	public @ResponseBody
	String processSubmit(@Valid SMS sms, BindingResult result,
			@ModelAttribute("ajaxRequest") boolean ajaxRequest, Model model,
			RedirectAttributes redirectAttrs) {
 
		log.info("SMS Body " + sms.getBody());
		log.info("From " + sms.getFrom());
		StringBuilder sb = new  StringBuilder();
		sb.append("<Response>");
		sb.append(" <Sms>Consider it done! "+sms.getFrom()+"</Sms>");
		sb.append("</Response>"); 
		
		return sb.toString();

	}

}
