package ma.emsi.post.service;


import ma.emsi.post.model.Comment;
import ma.emsi.post.model.Post;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PostService {

	public void create(Post a);

	public List<Post> findAll();

	public Post findById(int id) throws Exception;


	public List<Post> findByDate(LocalDate date);

	public List<Post> searchByKeyword(String keyword);

	public List<Post> searchByCategory(int id);

	void addCommentaire(Comment c);

	void deleteCommentaire(Comment c);

	public void update(Post a);

	public void delete(int id);
}
