/*
 * OpenQuestion.java
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

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class OpenQuestion extends Question {

	// Constructors -----------------------------------------------------------

	public OpenQuestion() {
		super();
	}


	// Attributes -------------------------------------------------------------

	private String	answer;


	@NotBlank
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	// Relationships ----------------------------------------------------------

}
