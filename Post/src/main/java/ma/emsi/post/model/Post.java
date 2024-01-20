package ma.emsi.post.model;

import jakarta.persistence.*;

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
    private Date createDate;
	
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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



	public Post(int id, String title, String body, Date createDate, String imageUrl , Categorie categorie) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.createDate = createDate;
	    this.imageUrl = imageUrl;
		this.categorie = categorie;

	}

	public Post() {
		
	}
}