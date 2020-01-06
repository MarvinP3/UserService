package com.orange.microservice.UserService.UserService.web.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orange.microservice.UserService.UserService.repository.UserRepository;

import model.User;

@RestController
public class UserController {
//Récupérer la liste des utilisateurs
	@Autowired
	private UserRepository userRepo;
    @ResponseBody 
    @RequestMapping(value="/Utilisateur", method=RequestMethod.GET)
    public List<User> listeUtilisateurs() {
    return userRepo.findAll();
        
	}
    
    //Récupérer un produit par son Id
    @GetMapping(value="/Utilisateur/{id}")
    public Optional<User> afficherUnUtilisateur(@PathVariable int id) {
        Optional<User> UnUtilisateur = userRepo.findById(id);
        return UnUtilisateur;
}
    
    @RequestMapping(value="/Utilisateur", method=RequestMethod.POST)
    public String createUtilisateur(@RequestParam User unUtilisateur) {
    	userRepo.save(unUtilisateur);
    	return " Un utilisateur à été crée";
    }
    
    @RequestMapping(value="/Utilisateur", method=RequestMethod.PUT)
    public String modifierUtilisateur(@RequestParam User unUtilisateur) {
    	userRepo.save(unUtilisateur);
    	return " Un utilisateur modifié";
    }
    
    @RequestMapping(value="/Utilisateur", method=RequestMethod.DELETE)
    public String supprimerUtilisateur(@RequestParam User unUtilisateur) {
    	userRepo.delete(unUtilisateur);
    	return " Un utilisateur supprimé";
    }
}