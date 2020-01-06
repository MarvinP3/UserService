package com.orange.microservice.UserService.UserService.web.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.User;

@RestController
public class UserController {
//R�cup�rer la liste des utilisateurs
    @ResponseBody 
    @RequestMapping(value="/Utilisateur", method=RequestMethod.GET)
    public String listeUtilisateurs() {
        return "la liste des utilisateur";
	}
    
    //R�cup�rer un produit par son Id
    @GetMapping(value="/Utilisateur/{id}")
    public User afficherUnUtilisateur(@PathVariable int id) {
        User UnUtilisateur = new User(id, new String("Laporte"), new String("Louis"), new String ("Ing�nieur"), new String("Laporte.louis@gmail.com"), new String("123456789") );
        return UnUtilisateur;
}
    @RequestMapping(value="/Utilisateur", method=RequestMethod.POST)
    public String createUtilisateur(@RequestParam User unUtilisateur) {
   
    	return " Un utilisateur cr�e";
    }
    
    @RequestMapping(value="/Utilisateur", method=RequestMethod.PUT)
    public String modifierUtilisateur(@RequestParam User unUtilisateur) {
    	
    	return " Un utilisateur modifi�";
    }
    
    @RequestMapping(value="/Utilisateur", method=RequestMethod.DELETE)
    public String supprimerUtilisateur(@RequestParam User unUtilisateur) {
    	
    	return " Un utilisateur supprim�";
    }
}