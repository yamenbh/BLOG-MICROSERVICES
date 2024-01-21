package ma.emsi.post.service.impl;


import ma.emsi.post.model.Comment;
import ma.emsi.post.model.Utilisateur;
import ma.emsi.post.repository.CommentRepository;
import ma.emsi.post.service.CommentService;
import ma.emsi.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private PostService postService;

	@Autowired
	private UtilisateurService utilisateurService;

	@Override
	public void create(Comment c) {
		if (c.getUtilisateur() != null && c.getUtilisateur().getEmail() != null) {
			Utilisateur existingUtilisateur = utilisateurService.getUtilisateurByEmail(c.getUtilisateur().getEmail());
			if (existingUtilisateur == null) {
				Utilisateur newUtilisateur = new Utilisateur();
				newUtilisateur.setEmail(c.getUtilisateur().getEmail());
				newUtilisateur.setNom(c.getUtilisateur().getNom());
				utilisateurService.addUtilisateur(newUtilisateur);
				c.setUtilisateur_id(newUtilisateur.getId());
			} else {
				c.setUtilisateur_id(existingUtilisateur.getId());
				utilisateurService.addUtilisateur(existingUtilisateur);
			}
		}
		commentRepository.save(c);
		postService.addCommentaire(c);
	}

	@Override
	public void update(Comment c) {
		Comment newComment = findById(c.getId());
		if (newComment != null) {
			newComment.setCreateDate(c.getCreateDate());
			newComment.setBody(c.getBody());
			commentRepository.save(newComment);
		}
	}

	@Override
	public void delete(int id) {
		Comment c = findById(id);
		postService.deleteCommentaire(c);
		commentRepository.deleteById(id);
	}

	@Override
	public List<Comment> findAll() {
		return commentRepository.findAll();
	}

	@Override
	public Comment findById(int id) {
		return commentRepository.findById(id);
	}

	@Override
	public List<Comment> findByPost(int id) {
		List<Comment> commentaires = commentRepository.findByPost(id);
		commentaires.forEach(comment -> {
			int utilisateurId = comment.getUtilisateur_id();
			Utilisateur utilisateur = utilisateurService.getUtilisateurById(utilisateurId);
			comment.setUtilisateur(utilisateur);
		});
		return commentaires;

	}

}
