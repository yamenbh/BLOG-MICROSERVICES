package ma.emsi.post.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.emsi.post.model.Post;
import ma.emsi.post.service.PostService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public String hello(){
        return "Test deploiement automatique";
    }

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        // Fetch posts from the database
        List<Post> posts = postService.getAllPosts();
        return posts;
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable int id) {
        return postService.getPostById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('AUTHOR')")
    public Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('AUTHOR')")
    public Post updatePost(@PathVariable int id, @RequestBody Post post) {
        return postService.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('AUTHOR')")
    public void deletePost(@PathVariable int id) {
        postService.deletePost(id);
    }

    @GetMapping("/utilisateur/{utilisateurId}")
    public List<Post> getPostsForUtilisateur(@PathVariable int utilisateurId) {
        return postService.getPostsByUtilisateurId(utilisateurId);
    }
}
