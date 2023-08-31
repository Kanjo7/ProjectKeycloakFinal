package com.keycloak.projectkeycloakfinal.services;

import com.keycloak.projectkeycloakfinal.entities.Post;
import com.keycloak.projectkeycloakfinal.exceptions.ResourceNotFoundException;
import com.keycloak.projectkeycloakfinal.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public void deletePost(int id) {
        postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "Id", id));
        postRepository.deleteById(id);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(int id) {
        return postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "Id", id));
    }

    public Post updatePost(Post post, int id) {
        Post p = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        p.setTitle(post.getTitle());
        p.setContent(post.getContent());

        postRepository.save(p);

        return p;
    }
}