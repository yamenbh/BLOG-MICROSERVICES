package ma.emsi.post.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/blog")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public String hello(){
        return "Test deploiement automatique      ";
    }


    @PostMapping(value = "/post", produces = { "application/json", "application/xml" }, consumes = {
            "application/json", "application/xml" })
    public ResponseEntity<Void> add(@RequestBody Post p) {
        postService.create(p);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/posts", produces = { "application/json", "application/xml" })
    public List<Post> findAll() {
        return postService.findAll();
    }

    @GetMapping(value = "/post/id/{id}", produces = { "application/json", "application/xml" })
    public Post findpost(@PathVariable int id) throws Exception {
        return postService.findById(id);
    }

    @GetMapping(value = "/post/categorie/{id}", produces = { "application/json", "application/xml" })
    public ResponseEntity<List<Post>> findPostByCategorie(@PathVariable int id) {
        List<Post> result = postService.searchByCategory(id);
        return ResponseEntity.ok().body(result);
    }


    @GetMapping(value = "/post/search/keyword/{keyword}", produces = { "application/json", "application/xml" })
    public ResponseEntity<List<Post>> sortByComments(@PathVariable String keyword) {
        List<Post> result = postService.searchByKeyword(keyword);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "/post/search/date/{createDate}", produces = { "application/json", "application/xml" })
    public ResponseEntity<List<Post>> sortByComments(@PathVariable LocalDate date) {
        List<Post> result = postService.findByDate(date);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping(value = "/post", produces = { "application/json", "application/xml" }, consumes = {
            "application/json", "application/xml" })
    public ResponseEntity<Void> update(@RequestBody Post p) {
        postService.update(p);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/post/{id}", produces = { "application/json", "application/xml" })
    public ResponseEntity<Void> delete(@PathVariable int id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
