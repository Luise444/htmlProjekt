package todorest.articlemgmt.services;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Category {
	Arbeit("Arbeit"), 
	Studium("Studium"), 
	Privat("Privat");
	
	


private String catag;

private Category(String catag) {
	this.catag = catag;

	}

@JsonCreator
public static Category decode(final String catag) {
		return Stream.of(Category.values()).filter(targetEnum -> targetEnum.catag.equals(catag)).findFirst().orElse(null);	
}
@JsonValue
public String getCatag() {
	return catag;

	}
}







	



