package ma.emsi.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.emsi.post.model.Categorie;



@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

    Categorie findById(int id);

    Categorie findByTitle(String title);

}
