/*
 * ExamPaper.java
 * 
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package domain;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Access(AccessType.PROPERTY)
public class ExamPaper extends DomainEntity {

	// Constructors -----------------------------------------------------------

	public ExamPaper() {
		super();

		answers = new HashSet<Answer>();
	}


	// Attributes -------------------------------------------------------------

	private Double	mark;
	private Integer	score;


	@Min(0)
	public Double getMark() {
		return mark;
	}

	public void setMark(Double mark) {
		this.mark = mark;
	}

	@Range(min = 1, max = 99)
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}


	// Relationships ----------------------------------------------------------

	private Collection<Answer>	answers;
	private Registration		registration;


	@NotEmpty
	@OneToMany(mappedBy = "examPaper", cascade = CascadeType.ALL)
	public Collection<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Collection<Answer> answers) {
		this.answers = answers;
	}

	public void addAnswer(Answer answer) {
		answers.add(answer);
		answer.setExamPaper(this);
	}

	public void removeAnswer(Answer answer) {
		answers.remove(answer);
		answer.setExamPaper(null);
	}

	@NotNull
	@Valid
	@OneToOne(optional = false)
	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

}
