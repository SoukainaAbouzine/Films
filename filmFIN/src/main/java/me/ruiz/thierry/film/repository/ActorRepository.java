package me.ruiz.thierry.film.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;



import me.ruiz.thierry.film.model.Actor;

@RepositoryRestResource(collectionResourceRel = "actors", path = "actors")
public interface ActorRepository extends JpaRepository<Actor, Long> {
	
	
	@Query("SELECT A FROM Actor a WHERE A.firstName like %:name% or A.lastName like %:name%" )

	List<Actor> findByNameContaining(@Param("name") String name);

	
	
	// FIXME full name search
	// https://stackoverflow.com/questions/4732955/java-jpa-search-user-in-database-by-first-and-last-name-return-too-many-resul?rq=1

	@Transactional
    @Modifying
	@Query(value="Delete from film_actor where actor_id=:id", nativeQuery = true)
	void deleteActorFilms(@Param("id") long id );
	public Actor saveActors(Actor a);
	

}
