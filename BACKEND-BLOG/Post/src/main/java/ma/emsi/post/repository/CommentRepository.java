package ma.emsi.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.emsi.post.model.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    Comment findById(int id);

    @Query("SELECT a FROM Comment a WHERE a.post.id = :id")
    List<Comment> findByPost(@Param("id") int id);
}
