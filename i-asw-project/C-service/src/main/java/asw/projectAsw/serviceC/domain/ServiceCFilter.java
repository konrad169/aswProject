package asw.projectAsw.serviceC.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ServiceCFilter {
	
	@Value("${instanceName}") 
	private String instanceName;

	public String prependINameString(String resouceString) {
		String finalString = instanceName + "[" + resouceString + "]";		
		return finalString;
	}
}
