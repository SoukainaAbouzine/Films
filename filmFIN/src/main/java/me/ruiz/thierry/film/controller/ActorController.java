package me.ruiz.thierry.film.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import me.ruiz.thierry.film.model.Actor;
import me.ruiz.thierry.film.repository.ActorRepository;

@RestController
public class ActorController {
	
	@Autowired
    ActorRepository actorRepository;


	@RequestMapping(value = "/api/deleteactor/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
		actorRepository.delete(id);
		actorRepository.deleteActorFilms(id);

    }
	@RequestMapping(value = "/Actors",method = RequestMethod.POST)
	 public Actor saveActor(@RequestBody Actor a) {
		 return actorRepository.save(a);
	 }
}
