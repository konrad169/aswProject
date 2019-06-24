package asw.projectAsw.serviceA.rest;




import org.springframework.web.bind.annotation.RestController;

import asw.projectAsw.serviceA.domain.ServiceAAnimalFilter;
import asw.projectAsw.serviceA.domain.SimpleProducerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger; 

@RestController
public class ControllerAPost {
	
	private final Logger logger = Logger.getLogger(ControllerAGet.class.toString()); 

	@Autowired
	private SimpleProducerService simpleProducerService;
	
	@Autowired
	private ServiceAAnimalFilter serviceFilter;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String postMessageWithAnimal() {	
		String finalMessage = serviceFilter.prependINameStringWithAnimal();
		logger.info("POST CONTROLLER :" + finalMessage);
		simpleProducerService.publish(finalMessage);
		return "Messaggio Inviato";
	}

}

