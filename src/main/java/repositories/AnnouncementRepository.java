/*
 * AnnouncementRepository.java
 * 
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package repositories;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Announcement;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {

	@Query("select a from Announcement a where a.moment > ?1")
	Collection<Announcement> findAllActive(Date currentMoment);

	@Query("select r.announcement from Registration r where r.owner.id = ?1")
	Collection<Announcement> findByCustomerId(int customerId);

	@Query("select a from Announcement a where a.reviewer.id = ?1")
	Collection<Announcement> findByReviewerId(int customerId);
}
