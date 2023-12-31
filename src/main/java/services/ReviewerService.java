/*
 * ReviewerService.java
 * 
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.ReviewerRepository;
import security.LoginService;
import security.UserAccount;
import domain.Reviewer;

@Service
@Transactional
public class ReviewerService {

	// Managed repository -----------------------------------------------------

	@Autowired
	private ReviewerRepository	reviewerRepository;


	// Supporting services ----------------------------------------------------

	// Constructors -----------------------------------------------------------

	public ReviewerService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	public Collection<Reviewer> findAll() {
		Collection<Reviewer> result;

		result = this.reviewerRepository.findAll();

		return result;
	}

	// Other business methods -------------------------------------------------

	public Reviewer findByPrincipal() {
		Reviewer result;
		UserAccount userAccount;

		userAccount = LoginService.getPrincipal();
		Assert.notNull(userAccount);
		result = this.findByUserAccount(userAccount);
		Assert.notNull(result);

		return result;
	}

	public Reviewer findByUserAccount(final UserAccount userAccount) {
		Assert.notNull(userAccount);

		Reviewer result;

		result = this.reviewerRepository.findByUserAccountId(userAccount.getId());

		return result;
	}

}
