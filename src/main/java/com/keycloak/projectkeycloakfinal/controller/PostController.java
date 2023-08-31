package com.keycloak.projectkeycloakfinal.controller;

import com.keycloak.projectkeycloakfinal.entities.Post;
import com.keycloak.projectkeycloakfinal.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/api/newpost")
    @PreAuthorize("hasRole('client_user')")
    public ResponseEntity<Post> savePost(@RequestBody Post post) {
        return new ResponseEntity<>(postService.savePost(post), HttpStatus.CREATED);
    }

    @GetMapping("/api/posts")
    @PreAuthorize("hasRole('client_admin')")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PutMapping("/api/posts/{id}")
    @PreAuthorize("hasRole('client_user')")
    public ResponseEntity<Post> updatePost(@PathVariable("id") int id, @RequestBody Post post) {
        return ResponseEntity.ok(postService.updatePost(post, id));
    }

    @DeleteMapping("/api/deletepost/{id}")
    @PreAuthorize("hasRole('client_user')")
    public ResponseEntity<String> deletePost(@PathVariable("id") int id) {
        postService.deletePost(id);
        return new ResponseEntity<String>("Post deleted!", HttpStatus.OK);
    }

    @GetMapping("/api/posts/{id}")
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<Post> getPostById(@PathVariable("id") int id) {
        postService.getPostById(id);
        return ResponseEntity.ok(postService.getPostById(id));
    }
}