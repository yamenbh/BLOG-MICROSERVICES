package ma.emsi.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ma.emsi.post.model.Comment;
import ma.emsi.post.service.CommentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/blog")
public class CommentController {

    @Autowired
    private  CommentService commentService;


    @PostMapping(value = "/commentaire", produces = { "application/json", "application/xml" }, consumes = {
            "application/json", "application/xml" })
    public ResponseEntity<Void> add(@RequestBody Comment commentaire) {
        commentService.create(commentaire);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/commentaires", produces = { "application/json", "application/xml" })
    public ResponseEntity<List<Comment>> findAll() {
        List<Comment> result = commentService.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "/commentaire/article/{id}", produces = { "application/json", "application/xml" })
    public ResponseEntity<List<Comment>> findByPostes(@PathVariable int id) {
        List<Comment> result = commentService.findByPost(id);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "/commentaire/id/{id}", produces = { "application/json", "application/xml" })
    public ResponseEntity<Comment> findcommentaire(@PathVariable int id) {
        Comment result = commentService.findById(id);
        if (result != null) {
            return ResponseEntity.ok().body(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/commentaire", produces = { "application/json", "application/xml" }, consumes = {
            "application/json", "application/xml" })
    public ResponseEntity<Void> update(@RequestBody Comment commentaire) {
        Comment existingCommentaire = commentService.findById(commentaire.getId());
        if (existingCommentaire != null) {
            commentService.update(commentaire);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/commentaire/{id}", produces = { "application/json", "application/xml" })
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Comment existingCommentaire = commentService.findById(id);
        if (existingCommentaire != null) {
            commentService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
