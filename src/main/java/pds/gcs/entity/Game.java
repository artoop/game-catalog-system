package pds.gcs.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "games")
public class Game extends Resource{

	@Column(name = "publisher")
	private String publisher;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "launch")
	private LocalDate launch;
	
	public Game() {
		
	}
	
	public Game(String title, String publisher, LocalDate launch, String image) {
		super();
		this.title = title;
		this.publisher = publisher;
		this.launch = launch;
		this.image = image;
	}
	
	@Override
	public void defineNotificationDate() {
		notificationDate = launch;
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
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public LocalDate getLaunch() {
		return launch;
	}

	public void setLaunch(LocalDate launch) {
		this.launch = launch;
	}
	
	
}
