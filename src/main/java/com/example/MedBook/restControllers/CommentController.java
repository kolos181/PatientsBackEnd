package com.example.MedBook.restControllers;

import com.example.MedBook.repos.CommentRepository;
import com.example.MedBook.Entities.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class CommentController {

    final CommentRepository commentRepository;

    @Autowired
    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping("api/comments/{id}")
    public List<Comments> findPatientComments(@PathVariable(value = "id") Long patientId) {
        List<Comments> comments = Optional.of(commentRepository.findPatientWithComments(patientId)).get();
        return comments;
    }

    @PostMapping("/api/comments")
    public Comments addComment(@Valid @RequestBody Comments comments) {
        return commentRepository.save(comments);
    }

    @DeleteMapping("/api/comments")
    public void deleteAllComments() {
        commentRepository.deleteAll();
    }

    @DeleteMapping("/api/comments/{id}")
    void deleteComment(@PathVariable(value = "id") Long id) {
        this.commentRepository.deleteById(id);
    }

}
