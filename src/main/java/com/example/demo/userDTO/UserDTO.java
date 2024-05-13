package com.example.demo.userDTO;

public class UserDTO {


    private String nom;


    private String prenom;

    private String email;

    private String tele;
    
    private String mdp;
    
    private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public UserDTO(String nom, String prenom, String email, String tele, String mdp) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tele = tele;
		this.mdp = mdp;
	}

	public UserDTO(String nom, String prenom, String email, String tele) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tele = tele;
	}

	public UserDTO(String email, String mdp) {
		super();
		this.email = email;
		this.mdp = mdp;
	}

	public UserDTO() {
		super();
	}

	public UserDTO(String nom, String prenom, String email, String tele, String mdp, String role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tele = tele;
		this.mdp = mdp;
		this.role = role;
	}

	public UserDTO(String email, String mdp, String role) {
		super();
		this.email = email;
		this.mdp = mdp;
		this.role = role;
	}
	
    
    
}
