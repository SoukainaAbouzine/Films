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

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="director")
public class Director implements Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column( name = "id", nullable = false, length=20)
	private long id ;
	@Column(name = "first_name", length=255)
	private String firstName;
	@Column(name = "last_name", length=255)
	private String lastName;
	@Column( name = "image", length=255)
	private String image;
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
	        name = "film_director", 
	        joinColumns = { @JoinColumn(name = " director_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "film_id") }
	    )
	 Set<Film> films = new HashSet<>();

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}

	@Override
	public String getImage() {
		// TODO Auto-generated method stub
		return image;
	}

	

	
}
