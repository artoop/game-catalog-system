package pds.gcs.entity;

import java.util.Date;

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
	
	@Column(name = "lauch_date")
	private String launchDate;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "launch")
	private Date launch;
	
	public Game() {
		
	}
	
	public Game(String title, String publisher, String launchDate, String image) {
		super();
		this.title = title;
		this.publisher = publisher;
		this.launchDate = launchDate;
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
	public String getLaunchDate() {
		return launchDate;
	}
	public void setLaunchDate(String launchDate) {
		this.launchDate = launchDate;
	}

	public Date getLaunch() {
		return launch;
	}

	public void setLaunch(Date launch) {
		this.launch = launch;
	}
	
	
}
