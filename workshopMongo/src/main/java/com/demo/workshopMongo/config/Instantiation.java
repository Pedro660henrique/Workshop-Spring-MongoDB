package com.demo.workshopMongo.config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.demo.workshopMongo.domain.Post;
import com.demo.workshopMongo.domain.User;
import com.demo.workshopMongo.dto.AuthorDTO;
import com.demo.workshopMongo.repository.PostRepository;
import com.demo.workshopMongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	//dependencia fraca
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		//limpa a coleção de post
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com", new ArrayList<>());
		User alex = new User(null, "Alex Green", "alex@gmail.com", new ArrayList<>());
		User bob = new User(null, "Bob Grey", "bob@gmail.com", new ArrayList<>());
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
			
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(maria);
	}

}
