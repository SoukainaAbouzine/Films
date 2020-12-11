package me.ruiz.thierry.film.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import me.ruiz.thierry.film.model.Film;
import me.ruiz.thierry.film.repository.FilmRepository;

@RestController
public class FilmController {
	
	@Autowired
    FilmRepository filmRepository;


	@RequestMapping(value = "/api/deletefilm/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
		filmRepository.deleteFilmDirectors(id);
		filmRepository.delete(id);

    }
	@RequestMapping(value = "/films",method = RequestMethod.POST)
	 public Film saveFilm(@RequestBody Film f) {
		 return filmRepository.save(f);
	 }
}
