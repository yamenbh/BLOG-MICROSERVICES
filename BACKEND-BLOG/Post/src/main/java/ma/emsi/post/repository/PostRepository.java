package ma.emsi.post.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ma.emsi.post.model.Categorie;
import ma.emsi.post.model.Comment;
import ma.emsi.post.model.Post;
import ma.emsi.post.model.Utilisateur;



public interface PostRepository extends JpaRepository<Post, Integer> {

	public Post findById(int id);

	public List<Post> findByDate(LocalDate date);



	@Query("SELECT a FROM Post a ORDER BY a.date DESC")
	public List<Post> sortByDate();

	@Query("SELECT a FROM Post a WHERE LOWER(a.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(a.title) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	List<Post> searchByKeyword(@Param("keyword") String keyword);

	@Query("SELECT a FROM Post a WHERE a.categorie.id = :id")
	List<Post> findByCategory(@Param("id") int id);

	


}
