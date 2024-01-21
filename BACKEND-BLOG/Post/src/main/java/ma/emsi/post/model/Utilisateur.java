package ma.emsi.post.model;

public class Utilisateur {

	/* Début de la déclaration des attributs */
	private int id;
    private String username;
    private String nom;
    private String prenom;
    private String email;
    private String password;

	/* Fin de la declaration des attributs */

	/* Debut des getters et setters */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Utilisateur(int id, String username, String nom, String prenom, String email, 
			String password) {
		super();
		this.id = id;
		this.username = username;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
	}

	public Utilisateur(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}


	public Utilisateur() {
		// Empty constructor (required by JPA)
	}
	/* Fin du constructeur */




}
