package asw.projectAsw.serviceB.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ServiceBFilter {

	@Value("${instanceName}") 
	private String instanceName;

	public String prependINameString(String resouceString) {
		String finalString = instanceName + ":" + resouceString;		
		return finalString;
	}
}
