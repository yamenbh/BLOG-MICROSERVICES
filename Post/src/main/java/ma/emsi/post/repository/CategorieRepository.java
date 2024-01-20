package ma.emsi.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.emsi.post.model.Categorie;
import ma.emsi.post.model.Comment;
import ma.emsi.post.model.Post;


@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

    @Query("Select ca from Categorie ca where ca.idCategorie=:id")
	Post getCategorie(@Param("id") int id);

	@Query("Select ca from Categorie ca ")
	List<Categorie> getAllCategories();
	
	
    @Query("SELECT ca FROM Categorie ca WHERE ca.id = :id")
    Comment getCategorieById(@Param("id") int id);

}
