package asw.projectAsw.serviceA.rest;



import org.springframework.web.bind.annotation.RestController;

import asw.projectAsw.serviceA.domain.AService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger; 

@RestController
public class ControllerAGet {
	
	private final Logger logger = Logger.getLogger(ControllerAGet.class.toString()); 

	@Autowired 
	private AService aservice;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getAllMessagesOnC() {
		String allMessages = aservice.getAllMessagesOnC(); 
		logger.info("getSentence(): " +  allMessages);
		return allMessages; 
	}

}
