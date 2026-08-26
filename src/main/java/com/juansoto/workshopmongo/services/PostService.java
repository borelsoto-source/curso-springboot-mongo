package com.juansoto.workshopmongo.services;

import com.juansoto.workshopmongo.domain.Post;
import com.juansoto.workshopmongo.repository.PostRepository;
import com.juansoto.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        return postRepository.findById(id).
                orElseThrow(()-> new ObjectNotFoundException("Post nao encontrado para o id "+id));
    }

    public List<Post> findByTitle(String text, LocalDateTime date) {
        return postRepository.searchPost(text, date);
    }

}
