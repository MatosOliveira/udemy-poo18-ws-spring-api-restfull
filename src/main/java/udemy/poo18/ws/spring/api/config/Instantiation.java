package udemy.poo18.ws.spring.api.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import udemy.poo18.ws.spring.api.domain.Post;
import udemy.poo18.ws.spring.api.domain.User;
import udemy.poo18.ws.spring.api.dto.AuthorDTO;
import udemy.poo18.ws.spring.api.dto.CommentDTO;
import udemy.poo18.ws.spring.api.repositories.PostRepository;
import udemy.poo18.ws.spring.api.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, LocalDate.parse("01/06/2023", dtf), "Partiu viagem", "Vou viajar para SP.", new AuthorDTO(maria));
		Post post2 = new Post(null, LocalDate.parse("01/06/2023", dtf), "Bom dia", "Acordei feliz hoje.", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", LocalDate.parse("01/06/2023", dtf), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite.", LocalDate.parse("01/06/2023", dtf), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um otimo dia!", LocalDate.parse("01/06/2023", dtf), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
		
	}

}
