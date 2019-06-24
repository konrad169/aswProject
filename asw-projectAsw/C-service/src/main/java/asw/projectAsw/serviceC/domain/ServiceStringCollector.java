package asw.projectAsw.serviceC.domain;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;


@Service
public class ServiceStringCollector {

	
	private List<String> stringsList = new ArrayList<>();;
	
	
	public void setString(String addString) {		
		stringsList.add(addString);
	}
	
	@Override
	public String toString() {
		String fullString = "";
		for(String singleMessage : stringsList) {
			fullString += singleMessage + ",";
		}
		return fullString;
	}
}
