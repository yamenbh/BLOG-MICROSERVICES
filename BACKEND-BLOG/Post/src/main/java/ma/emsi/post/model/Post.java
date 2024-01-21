package ma.emsi.post.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "post")
public class Post {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "body", columnDefinition = "TEXT")
    private String body;
   
	@Temporal(TemporalType.DATE)
	@Column(nullable=false, name="create_date", updatable = false)
    private LocalDate date;
	
	@Column(name = "image_url")
	private String imageUrl;
    
	@ManyToOne
	private Categorie categorie;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate Date) {
		this.date = date;
	}

	public String getImageUrl() {
	    return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
	    this.imageUrl = imageUrl;
	}


	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}



	public Post(int id, String title, String body, LocalDate date, String imageUrl , Categorie categorie) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.date = date;
	    this.imageUrl = imageUrl;
		this.categorie = categorie;

	}

	public Post() {
		
	}
}