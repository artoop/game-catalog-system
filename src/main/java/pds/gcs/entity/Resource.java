package pds.gcs.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Resource {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	protected Long id;
	
	@Column(name = "title", nullable = false)
	protected String title;

	@OneToMany(mappedBy = "resource", cascade = CascadeType.ALL, orphanRemoval = true)
	protected List<Comment> comments;
	
		
	public Resource() {
		
	}
	
	public Resource(String title) {
		super();
		this.title = title;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
