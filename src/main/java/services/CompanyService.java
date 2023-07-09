
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Company;
import repositories.CompanyRepository;

@Service
@Transactional
public class CompanyService {

	// Managed repository -----------------------------------------------------
	@Autowired
	private CompanyRepository companyRepository;

	// Supporting services ----------------------------------------------------


	// Constructors -----------------------------------------------------------
	public CompanyService() {
		super();
	}
	// Simple CRUD methods ----------------------------------------------------
	public Collection<Company> findAll() {
		Collection<Company> result;

		result = this.companyRepository.findAll();
		Assert.notNull(result);

		return result;
	}
	// Other business methods -------------------------------------------------

}
