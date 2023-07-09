
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Company extends DomainEntity {

	// Constructors -----------------------------------------------------------
	public Company() {
		super();
	}


	// Attributes -------------------------------------------------------------
	private String name;


	@NotBlank
	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}


	// Relationships ----------------------------------------------------------
	private Certification certification;


	@OneToOne(mappedBy = "company")
	public Certification getCertification() {
		return this.certification;
	}

	public void setCertification(final Certification certification) {
		this.certification = certification;
	}

}
