
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Pencil458;
import repositories.Pencil458Repository;

@Service
@Transactional
public class Pencil458Service {

	// Managed repository -----------------------------------------------------
	@Autowired
	private Pencil458Repository pencil458Repository;
	// Supporting services ----------------------------------------------------

	// Constructors -----------------------------------------------------------


	// Simple CRUD methods ----------------------------------------------------
	public Collection<Pencil458> findAllWithCertificate() {
		Collection<Pencil458> result;

		Assert.notNull(this.pencil458Repository);
		result = this.pencil458Repository.findAllWithCertificate();
		Assert.notNull(result);

		return result;
	}

	public Pencil458 findOne(final int pencil458Id) {
		Pencil458 result;

		result = this.pencil458Repository.findOne(pencil458Id);

		return result;
	}
	public Pencil458 save(final Pencil458 pencil458Id) {
		assert pencil458Id != null;

		Pencil458 result;

		result = this.pencil458Repository.save(pencil458Id);

		return result;
	}
	// Other business methods -------------------------------------------------
}
