
package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Pencil458 extends DomainEntity {
	// Constructors -----------------------------------------------------------

	public Pencil458() {
		super();
	}


	// Attributes -------------------------------------------------------------
	private String	description375;
	private Date	anniversary866;
	private int		weight343;
	private Date	birthdate045;


	@NotBlank
	@Size(min = 2)
	public String getDescription375() {
		return this.description375;
	}

	public void setDescription375(final String description375) {
		this.description375 = description375;
	}
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Past
	public Date getAnniversary866() {
		return this.anniversary866;
	}

	public void setAnniversary866(final Date anniversary866) {
		this.anniversary866 = anniversary866;
	}

	@NotNull
	@Range(min = 48, max = 64)
	public int getWeight343() {
		return this.weight343;
	}

	public void setWeight343(final int weight343) {
		this.weight343 = weight343;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date getBirthdate045() {
		return this.birthdate045;
	}

	public void setBirthdate045(final Date birthdate045) {
		this.birthdate045 = birthdate045;
	}


	// Relationships ----------------------------------------------------------
	private Certification certification;


	@Valid
	@ManyToOne(optional = true)
	public Certification getCertification() {
		return this.certification;
	}

	public void setCertification(final Certification certification) {
		this.certification = certification;
	}

}
