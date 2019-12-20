package com.orange.microservice.UserService.UserService.web.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import model.Users;

@RestController
public class UserController {
//Récupérer la liste des utilisateurs
    @ResponseBody 
    @RequestMapping(value="/Utilisateur", method=RequestMethod.GET)
    public String listeUtilisateurs() {
        return "la liste des utilisateur";
	}	

   

    //Récupérer un utilisateur par son id
    @GetMapping(value="/Utilisateurs/{id}")
    public Users afficherUnUtilisateur(@PathVariableintid) {
        Users utilisateur=new utilisateur(id, new String("Aspirateur"), 100 );
        return utilisateur;
    }
   
}