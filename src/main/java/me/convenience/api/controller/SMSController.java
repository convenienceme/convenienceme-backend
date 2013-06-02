package me.convenience.api.controller;

import java.io.IOException;

import javax.validation.Valid;

import me.convenience.api.model.SMS;
import me.convenience.api.model.Status;
import me.convenience.api.model.provider.SMSProvider;

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

import com.twilio.sdk.TwilioRestException;
/**
 * 
 * @author jsreevalsan
 *
 */
@Controller
@RequestMapping("/sms")
public class SMSController {

	Logger log = Logger
			.getLogger("me.convenience.api.controller.SMSController");

	// Invoked on every request

	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}

	// Invoked initially to create the "form" attribute
	// Once created the "form" attribute comes from the HTTP session (see
	// @SessionAttributes)

	@ModelAttribute("sms")
	public SMS createSMSBean() {
		return new SMS();
	}

	@RequestMapping(method = RequestMethod.GET)
	public void sms() {
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	Status processSubmit(@Valid SMS sms, BindingResult result,
			@ModelAttribute("ajaxRequest") boolean ajaxRequest, Model model,
			RedirectAttributes redirectAttrs) {

		Status s = new Status();
		if (result.hasErrors()) {
			s.setStatusCd("0");
			s.setStatusDesc("Text sending Failed. Please try again later.. " + result.toString());
		return s ;
		}

		log.info(String.format("SMS %s with text %s ", sms.getPhoneNumber(),
				sms.getSmsText()));

		SMSProvider provider = new SMSProvider() ;
		
		try {
			provider.postSMS(sms);
		} catch (IOException | TwilioRestException e) {
			 
			e.printStackTrace();
			s.setStatusCd("0");
			s.setStatusDesc("Text sending Failed, please check logs ");
			return s ;
		} 
		
		s.setStatusCd("1");
		s.setStatusDesc("Success");

		return s;

	}

}
