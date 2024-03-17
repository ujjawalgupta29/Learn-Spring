package com.learn.webservices.restfulwebservices.user;

import com.learn.webservices.restfulwebservices.jpa.PostRepository;
import com.learn.webservices.restfulwebservices.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaResource {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }

        EntityModel<User> entityModel = EntityModel.of(user.get());

        WebMvcLinkBuilder link =  WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").
                buildAndExpand(savedUser.getId()).
                toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }

        return user.get().getPosts();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Post> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }

        post.setUser(user.get());
        Post postSaved = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").
                buildAndExpand(postSaved.getId()).
                toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/jpa/users/{user_id}/posts/{post_id}")
    public Post retrieveSpecificPostForUser(@PathVariable int user_id, @PathVariable int post_id) {
        Optional<Post> post = postRepository.findById(post_id);
        if(post.isEmpty()) {
            throw new UserNotFoundException("id:" + post_id);
        }

        return post.get();
    }
}
