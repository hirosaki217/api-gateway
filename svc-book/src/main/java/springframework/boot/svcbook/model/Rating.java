package springframework.boot.svcbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rating {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Long bookId;
	private int stars;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public Rating( Long bookId, int stars) {

		this.bookId = bookId;
		this.stars = stars;
	}
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
