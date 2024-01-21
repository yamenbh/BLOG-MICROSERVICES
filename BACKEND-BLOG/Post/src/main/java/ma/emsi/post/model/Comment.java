package ma.emsi.post.model;

import jakarta.persistence.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "body", columnDefinition = "TEXT")
	private String body;

	@Temporal(TemporalType.DATE)
	@Column(nullable=true, name="create_date", updatable = false)
	private Date createDate;

	@Transient
	@ManyToOne
	private Utilisateur utilisateur;

	@ManyToOne
	@JoinColumn(name = "post_id")
	@JsonBackReference
	private Post post;

	private int utilisateur_id;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public int getUtilisateur_id() {
		return utilisateur_id;
	}

	public void setUtilisateur_id(int utilisateur_id) {
		this.utilisateur_id = utilisateur_id;
	}

	public Comment(int id, String body, Date createDate, Utilisateur utilisateur, Post post) {
		super();
		this.id = id;
		this.body = body;
		this.createDate = createDate;
		this.utilisateur = utilisateur;
		this.post = post;
	}

	public Comment(int id, @NotBlank(message = "Texte ne peut pas etre vide") String body, Date createDate, Utilisateur utilisateur,@NotBlank(message = "Post ne peut pas etre vide") Post post, int utilisateur_id) {
		this.id = id;
		this.body = body;
		this.createDate = createDate;
		this.utilisateur = utilisateur;
		this.post = post;
		this.utilisateur_id = utilisateur_id;
	}

	public Comment() {

	}


}