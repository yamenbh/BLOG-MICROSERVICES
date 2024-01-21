package ma.emsi.post.service.impl;


import ma.emsi.post.model.Comment;
import ma.emsi.post.model.Post;
import ma.emsi.post.repository.PostRepository;
import ma.emsi.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Override
	public void create(Post a) {
		postRepository.save(a);
	}

	@Override
	public List<Post> findAll() {
		return postRepository.findAll();
	}

	@Override
	public Post findById(int id) throws Exception {
		return postRepository.findById(id);
	}



	@Override
	public List<Post> findByDate(LocalDate date) {
		return postRepository.findByDate(date);
	}

	@Override
	public List<Post> searchByKeyword(String keyword) {
		return postRepository.searchByKeyword(keyword);
	}

	@Override
	public List<Post> searchByCategory(int id) {
		return postRepository.findByCategory(id);
	}


	@Override
	public void addCommentaire(Comment c) {
		Post post;
		try {
			post = findById(c.getPost().getId());
			if (post != null) {
				postRepository.save(post);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteCommentaire(Comment c) {
		Post post;
		try {
			post = findById(c.getPost().getId());
			if (post != null) {
				postRepository.save(post);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Post a) {
		Post newPost;
		try {
			newPost = findById(a.getId());
			if (newPost != null) {
				System.out.println(newPost);
				newPost.setCategorie(a.getCategorie());
				newPost.setDate(a.getDate());
				newPost.setImageUrl(a.getImageUrl());
				newPost.setBody(a.getBody());
				newPost.setTitle(a.getTitle());
				postRepository.save(newPost);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		postRepository.deleteById(id);
	}
}