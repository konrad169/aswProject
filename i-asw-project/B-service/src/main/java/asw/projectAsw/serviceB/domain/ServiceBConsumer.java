package asw.projectAsw.serviceB.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.projectAsw.serviceB.domain.CService;

import java.util.logging.Logger;

@Service 
public class ServiceBConsumer {

    private Logger logger = Logger.getLogger(ServiceBConsumer.class.toString());
    
    @Autowired
    private ServiceBFilter serviceFilter;
    
    @Autowired 
	private CService crequestservice;
    
    

    public void onMessage(String message) {
		logger.info("RECEIVED MESSAGE: " + message);
		String finalMessage = serviceFilter.prependINameString(message);
		String answer = crequestservice.postMessage(finalMessage);
		logger.info("RECEIVED AFTER POST: " + answer);
	}
	
}
