package ma.emsi.post.service;


import ma.emsi.post.model.Categorie;

import java.util.List;

public interface CategorieService {

	public void create(Categorie c);

	public void update(Categorie c);

	public void delete(int id);

	public List<Categorie> findAll();

	public Categorie findById(int id);

	public Categorie findByTitle(String title);


}