package asw.projectAsw.serviceB.cservice;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import asw.projectAsw.api.rest.CreateSingleMessageRequest;

@FeignClient("serviceC")
public interface CClient {
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public String postMessage(@RequestBody CreateSingleMessageRequest message);
	
}
