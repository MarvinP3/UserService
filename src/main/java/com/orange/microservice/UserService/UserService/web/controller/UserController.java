package com.orange.microservice.UserService.UserService.web.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orange.microservice.UserService.UserService.model.User;
import com.orange.microservice.UserService.UserService.repository.UserRepository;

@RestController
public class UserController {
//R�cup�rer la liste des utilisateurs
	@Autowired
	private UserRepository userRepo;
    @ResponseBody 
    @RequestMapping(value="/Utilisateur", method=RequestMethod.GET)
    public List<User> listeUtilisateurs() {
    return userRepo.findAll();
        
	}
    
    //R�cup�rer un utilisateur par son Id
    @GetMapping(value="/Utilisateur/{id}")
    public Optional<User> afficherUnUtilisateur(@PathVariable int id) {
        Optional<User> UnUtilisateur = userRepo.findById(id);
        return UnUtilisateur;
}
    
    @RequestMapping(value="/Utilisateur", method=RequestMethod.POST)
    public String createUtilisateur(@RequestBody User unUtilisateur) {
    	userRepo.save(unUtilisateur);
    	return " Un utilisateur � �t� cr�e";
    }
    
    
    @RequestMapping(value="/Utilisateur/{id}", method=RequestMethod.PUT)
    public String modifierUtilisateur(@RequestBody User unUtilisateur) {
    	userRepo.save(unUtilisateur);
    	return " Un utilisateur modifi�";
    }
    
    @RequestMapping(value="/Utilisateur/{id}", method=RequestMethod.DELETE)
    public String supprimerUtilisateur(@RequestBody User unUtilisateur) {
    	userRepo.delete(unUtilisateur);
    	return " Un utilisateur supprim�";
    }
    
    
    @PostMapping(value="/Utilisateur/Authentification")
    public String authentificationUtilisateur(@RequestBody User unUtilisateur) {
    	Optional<User> stockUtilisateur =userRepo.findByLoginAndMotDePasse(unUtilisateur.getLogin(), unUtilisateur.getMotDePasse());
    	 if (stockUtilisateur.isPresent()) {
    		 return "log et mot de passe correcte";
    	 }
    	 else {
    		 return "log et mot de passe incorrecte";
    	 }
    	
    }
}