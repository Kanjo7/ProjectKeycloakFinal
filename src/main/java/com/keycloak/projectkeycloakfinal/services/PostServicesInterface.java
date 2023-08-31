package com.keycloak.projectkeycloakfinal.services;

import com.keycloak.projectkeycloakfinal.entities.Post;

import java.util.List;

public interface PostServicesInterface {

    Post savePost(Post post);

    List<Post> getAllPosts();

    Post getPostById(int id);

    Post updatePost(Post post, int id);

    void deletePost(int id);

}
