package udemy.poo18.ws.spring.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import udemy.poo18.ws.spring.api.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
