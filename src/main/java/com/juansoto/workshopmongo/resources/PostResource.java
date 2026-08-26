package com.juansoto.workshopmongo.resources;

import com.juansoto.workshopmongo.domain.Post;
import com.juansoto.workshopmongo.resources.util.URL;
import com.juansoto.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping("/title")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text") String text,
                                                  @RequestParam(value = "date") LocalDateTime date){
        text = URL.decodeParam(text);
        List<Post> list = postService.findByTitle(text,date);
        return ResponseEntity.ok().body(list);
    }
}
