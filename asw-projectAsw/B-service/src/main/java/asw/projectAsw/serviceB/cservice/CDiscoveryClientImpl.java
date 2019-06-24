package asw.projectAsw.serviceB.cservice;

import java.net.URI;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.client.RestTemplate;


import asw.projectAsw.api.rest.CreateSingleMessageRequest;

@Service
public class CDiscoveryClientImpl implements CClient {
	@Autowired 
	private DiscoveryClient discoveryClient;

	public String postMessage(String service, String message) {
		List<ServiceInstance> list = discoveryClient.getInstances(service);
		if (list!=null && list.size()>0) {
			URI uri = list.get(0).getUri();
			if (uri!=null) {
				return new RestTemplate().postForObject(uri, new CreateSingleMessageRequest(message), String.class);
			}
		}
		return null;
} 
}
