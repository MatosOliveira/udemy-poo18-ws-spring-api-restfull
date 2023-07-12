package udemy.poo18.ws.spring.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import udemy.poo18.ws.spring.api.domain.User;
import udemy.poo18.ws.spring.api.dto.UserDTO;
import udemy.poo18.ws.spring.api.repositories.UserRepository;
import udemy.poo18.ws.spring.api.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public User fromDTO(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id); 
	}
	
	
}
