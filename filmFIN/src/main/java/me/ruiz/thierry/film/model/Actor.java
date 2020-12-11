package me.ruiz.thierry.film.model;

import java.util.HashSet;
import java.util.Set;

//import org.apache.commons.lang3.builder.ToStringBuilder;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
@Table(name="actor")
public class Actor implements Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column( name = "id", nullable = false, length=20)
	private long id ;
	@Column(name = "first_name",  length=255)
	private String firstName;
	@Column(name = "last_name", length=255)
	private String lastName;
	@Column( name = "image",  length=255)
	private String image;
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
	        name = "film_actor", 
	        joinColumns = { @JoinColumn(name = " actor_id") }, 
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
	
	public String getName() {
		String name ="";
		if (this.firstName!=null) {
			name+=this.firstName +"";
		}
		if (this.lastName!=null) {
			name+= lastName;
		}
		return name;
	}

	
}
