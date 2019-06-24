package asw.projectAsw.serviceA.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AService {

	@Autowired 
	private CService crequestservice;

	public String getAllMessagesOnC() {
		String allMessages = 
				crequestservice.getAllMessages() + ".";
		return allMessages; 
}
}
