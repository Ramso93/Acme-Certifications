/*
 * OpenAnswer.java
 * 
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

@Entity
@Access(AccessType.PROPERTY)
public class OpenAnswer extends Answer {

	// Constructors -----------------------------------------------------------

	public OpenAnswer() {
		super();
	}


	// Attributes -------------------------------------------------------------

	private String	text;


	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	// Relationships ----------------------------------------------------------

}
