package ma.emsi.post.service;

import ma.emsi.post.model.Comment;

import java.util.List;

public interface CommentService {

	void create(Comment c);

	void update(Comment c);

	void delete(int id);

	List<Comment> findAll();

	Comment findById(int id);

	List<Comment> findByPost(int id);

}
