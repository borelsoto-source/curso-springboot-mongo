package com.juansoto.workshopmongo.resources;

import com.juansoto.workshopmongo.domain.Post;
import com.juansoto.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping("{id}")
    public ResponseEntity<Post> findPostById(@PathVariable String id){
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }
}
