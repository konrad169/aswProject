package asw.projectAsw.serviceB.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ServiceBFilter {

	@Value("${istanceName}") 
	private String istanceName;

	public String prependINameString(String resouceString) {
		String finalString = istanceName + ":" + resouceString;		
		return finalString;
	}
}
