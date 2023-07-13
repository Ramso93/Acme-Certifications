
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Pencil458;

@Repository
public interface Pencil458Repository extends JpaRepository<Pencil458, Integer> {

	/*
	 * @Query("SELECT p FROM pencil458 JOIN certification ON pencil458.certification_id = certification.id WHERE pencil458.weight343 > '50'")
	 * Collection<Pencil458> findAllWithCertificate();
	 */

	@Query("select p from Pencil458 p where p.weight343 < '50'")
	Collection<Pencil458> findAllWithCertificate();
}
