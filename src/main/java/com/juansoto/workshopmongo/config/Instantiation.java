package com.juansoto.workshopmongo.config;

import com.juansoto.workshopmongo.domain.Post;
import com.juansoto.workshopmongo.domain.User;
import com.juansoto.workshopmongo.repository.PostRepository;
import com.juansoto.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... arg0) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new  User(null, "Maria Brown", "maria@gmail.com");
        User Alex = new  User(null, "Alex Grenn", "alex@gmail.com");
        User Bob = new  User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new  Post(null, LocalDateTime.parse("2018-03-21T00:00:00"), "Partiu Viagem!", "Vou Viajar Para São Paulo. Abraços", maria);
        Post post2 = new  Post(null, LocalDateTime.parse("2018-03-23T00:00:00"), "Bom dia", "Acordei feliz hoje!", maria);

        userRepository.saveAll(Arrays.asList(maria,Alex,Bob));
        postRepository.saveAll(Arrays.asList(post1,post2));

    }
}
