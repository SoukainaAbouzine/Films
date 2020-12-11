package me.ruiz.thierry.film.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="film")
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column( name = "id", nullable = false, length=20)
	private long id ;
	
	private String image;
	
	private String title;
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
	        name = "film_actor", 
	        joinColumns = { @JoinColumn(name = "film_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "actor_id") }
	    )
	Set<Actor> actors = new HashSet<>();
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
	        name = "film_director", 
	        joinColumns = { @JoinColumn(name = "film_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "director_id") }
	    )
	 Set<Director> directors = new HashSet<>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	

	


	
}
