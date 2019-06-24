package asw.projectAsw.serviceB.cservice;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Logger; 

import asw.projectAsw.serviceB.domain.CService;

@Service
public class crequestservice implements CService {
	
	private final Logger logger = Logger.getLogger(crequestservice.class.toString()); 

	@Autowired 
	private CClient cClient;
	
	public String postMessage(String message) {
		return cClient.postMessage("serviceC", message); 
}
}
