package asw.projectAsw.serviceC.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ServiceCFilter {
	
	@Value("${istanceName}") 
	private String istanceName;

	public String prependINameString(String resouceString) {
		String finalString = istanceName + "[" + resouceString + "]";		
		return finalString;
	}
}
