package com.orange.microservice.UserService.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PathVariable;

import com.orange.microservice.UserService.UserService.model.User;
import com.orange.microservice.UserService.UserService.repository.UserRepository;

@SpringBootTest
class UserServiceApplicationTests {
	@Autowired
	private UserRepository userRepo;

	@Test
	void ajouterUnUtilisateur() {
		User unUtilisateur = new User ("PATINI","Marvin","Developpeur","marvin.patini@gmail.com","Pyke","123456789");
		userRepo.save(unUtilisateur);
		Optional<User> stockUtilisateur = afficherUnUtilisateurByName("PATINI");
		assertEquals(unUtilisateur.getNom(), stockUtilisateur.get().getNom());
		System.out.println(unUtilisateur.getNom());
		System.out.println(stockUtilisateur.get().getNom());
	}
	
	public Optional<User> afficherUnUtilisateurByName(String nom) {
	       Optional<User> UnUtilisateur = userRepo.findByNom(nom);
	       return UnUtilisateur;	     
	}
	void modifierUnUtilisateur() {
		User unUtilisateur = new User ("SOREL","Stephane","Develeppeur","stephane.sorel@gmail.com","abcd","987654321");
		userRepo.save(unUtilisateur);
		Optional<User> stockUtilisateur = modifierUtilisateurById();
	}
	
	public Optional<User> modifierUtilisateurById() {
		   Optional<User> unUtilisateur = userRepo.findById(nom,prenom,fonction,mail,login,motDePasse);
		   return unUtilisateur;
	}
	
	}	
	


