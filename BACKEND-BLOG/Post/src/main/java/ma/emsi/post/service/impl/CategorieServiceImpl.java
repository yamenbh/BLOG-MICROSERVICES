package ma.emsi.post.service.impl;


import ma.emsi.post.model.Categorie;
import ma.emsi.post.repository.CategorieRepository;
import ma.emsi.post.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService {

	@Autowired
	private CategorieRepository categorieRepository;

	@Override
	public void create(Categorie c) {
		categorieRepository.save(c);
	}

	@Override
	public void update(Categorie c) {
		Categorie newCategorie = findById(c.getId());
		if (newCategorie != null) {
			newCategorie.setTitle(c.getTitle());
			categorieRepository.save(newCategorie);
		}
	}

	@Override
	public void delete(int id) {
		categorieRepository.deleteById(id);
	}

	@Override
	public List<Categorie> findAll() {
		return categorieRepository.findAll();
	}

	@Override
	public Categorie findById(int id) {
		return categorieRepository.findById(id);
	}

	@Override
	public Categorie findByTitle(String title) {
		return categorieRepository.findByTitle(title);	}


}
