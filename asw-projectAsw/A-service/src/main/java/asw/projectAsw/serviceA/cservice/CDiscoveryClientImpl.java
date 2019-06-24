package asw.projectAsw.serviceA.cservice;

import java.net.URI;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.client.RestTemplate;

@Service
public class CDiscoveryClientImpl implements CClient {
	
	@Autowired 
	private DiscoveryClient discoveryClient;

	public String getAllMessages(String service) {
		List<ServiceInstance> list = discoveryClient.getInstances(service);
		if (list!=null && list.size()>0) {
			URI uri = list.get(0).getUri();
			if (uri!=null) {
				return new RestTemplate().getForObject(uri,String.class);
			}
		}
		return null;
} 
}
