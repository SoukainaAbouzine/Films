package me.ruiz.thierry.film.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;



import me.ruiz.thierry.film.model.Director;


@RepositoryRestResource(collectionResourceRel = "directors", path = "directors")
public interface DirectorRepository extends JpaRepository<Director, Long> {
	@Query("SELECT D FROM Director a WHERE D.firstName like %:name% or D.lastName like %:name%" )
	List<Director> findByNameContaining(@Param("name") String name);
	
	// FIXME full name search
	// https://stackoverflow.com/questions/4732955/java-jpa-search-user-in-database-by-first-and-last-name-return-too-many-resul?rq=1

	@Transactional
    @Modifying
	@Query(value="", nativeQuery = true)
	void deleteDirectorFilms(@Param("id") long id );
	public Director saveDirectors(Director d);
}


