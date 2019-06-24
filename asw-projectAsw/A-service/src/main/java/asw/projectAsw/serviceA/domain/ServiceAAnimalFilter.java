package asw.projectAsw.serviceA.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ServiceAAnimalFilter {

	@Value("${animalsName}") 
	private String animalName;
	
	@Value("${istanceName}") 
	private String istanceName;
	
	
	public String prependINameStringWithAnimal() {
		return istanceName + ":" + getRandomAnimalName();
	}
	
	private String getRandomAnimalName() {
		/* restituisce una parola a caso tra le parole di questo tipo */ 
		String[] wordArray = animalName.split(",");
		int i = (int) (Math.round(Math.random()*(wordArray.length-1)));
		String word = wordArray[i];
		return word; 
	}
}
