package com.orange.microservice.UserService.UserService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String fonction;
	private String mail;
	private String motDePasse;
	
	
	public User(int id, String nom, String prenom, String fonction, String mail, String motDePasse) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;
		this.mail = mail;
		this.motDePasse = motDePasse;
	}
	
	public User(String nom, String prenom, String fonction, String mail, String motDePasse) {
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;
		this.mail = mail;
		this.motDePasse = motDePasse;
		// TODO Auto-generated constructor stub
	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ",nom=" + nom + ", prenom=" + prenom + ", fonction=" + fonction + ", mail=" + mail +", motDePasse =" + motDePasse + "]";
	}
	
	
	
	
	

}
