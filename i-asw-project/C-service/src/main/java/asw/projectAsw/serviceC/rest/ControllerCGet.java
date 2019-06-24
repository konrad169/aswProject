package asw.projectAsw.serviceC.rest;




import org.springframework.web.bind.annotation.RestController;

import asw.projectAsw.serviceC.domain.ServiceCFilter;
import asw.projectAsw.serviceC.domain.ServiceStringCollector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger; 

@RestController
public class ControllerCGet {
	
	private final Logger logger = Logger.getLogger(ControllerCGet.class.toString()); 

	@Autowired 
	private ServiceStringCollector stringCollector;
	
	@Autowired
	private ServiceCFilter servicefilter;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getCollectedStrings() {
		String allStrings = servicefilter.prependINameString(stringCollector.toString()); 
		logger.info("CGet Result: " + allStrings);
		return allStrings; 
	}

}
