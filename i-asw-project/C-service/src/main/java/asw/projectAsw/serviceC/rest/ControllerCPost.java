package asw.projectAsw.serviceC.rest;


import asw.projectAsw.api.rest.*;

import org.springframework.web.bind.annotation.RestController;

import asw.projectAsw.serviceC.domain.ServiceCFilter;
import asw.projectAsw.serviceC.domain.ServiceStringCollector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger; 

@RestController
public class ControllerCPost {
	
	private final Logger logger = Logger.getLogger(ControllerCPost.class.toString()); 

	@Autowired
	private ServiceStringCollector servicecollector;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String postDataString(@RequestBody CreateSingleMessageRequest request) {
		String bodyrequest = request.getMessage(); 
		logger.info("postDataString(): " + bodyrequest);
		servicecollector.setString(bodyrequest);
		return "OK";
	}

}
