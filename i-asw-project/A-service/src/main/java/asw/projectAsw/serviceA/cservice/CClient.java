package asw.projectAsw.serviceA.cservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("serviceC")
public interface CClient {
	
	/*
	 * Old Interface without Feign
	public String getAllMessages(String wordUri);

	*/
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getAllMessages();
}
