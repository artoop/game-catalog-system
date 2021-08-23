package pds.gcs.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "email", nullable = false, unique = true)
	@Email(message = "Please enter a valid email")
	@NotEmpty(message = "Please provice an email")
	private String email;
	
	@Column(name = "password")
	@Transient
	private String password;
	
	@Column(name = "first_name")
	@NotEmpty(message = "Please enter your first name")
	private String firstName;
	
	@Column(name = "last_name")
	@NotEmpty(message = "Please enter your last name")
	private String lastName;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@Column(name = "confirmation_token")
	private String confirmationToken;
	
	@ManyToMany
	@JoinTable(name = "user_liked_resources", joinColumns = 
	{@JoinColumn(name = "user_id")}, inverseJoinColumns = 
		{@JoinColumn(name = "resource_id")})
	private List<Resource> favorites = new ArrayList<Resource>();
	
	@ManyToMany
	@JoinTable(name = "notifications", joinColumns = 
	{@JoinColumn(name = "user_id")}, inverseJoinColumns = 
		{@JoinColumn(name = "resource_id")})
	private List<Resource> resourcesToNotify = new ArrayList<Resource>();
	
	public void addFavorite(Resource resource) {
		favorites.add(resource);
	}

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean value) {
		this.enabled = value;
	}

	public List<Resource> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Resource> favorites) {
		this.favorites = favorites;
	}
}