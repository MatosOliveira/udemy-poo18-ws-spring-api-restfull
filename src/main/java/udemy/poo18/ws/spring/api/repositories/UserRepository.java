package udemy.poo18.ws.spring.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import udemy.poo18.ws.spring.api.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
