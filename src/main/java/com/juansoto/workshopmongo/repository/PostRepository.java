package com.juansoto.workshopmongo.repository;

import com.juansoto.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    @Query("{ " +
            "$or:[" +
            " {'title': { $regex: ?0, $options: 'i' } }, " +
            " {'body': { $regex: ?0, $options: 'i' } }," +
            " {'comments.text': { $regex: ?0, $options: 'i' } }" +
            " ], "+
            " 'date': ?1 " +
            "}")
    List<Post> searchPost(String text, LocalDateTime date);

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);
    List<Post> findByTitleContainingIgnoreCase(String text);
}
