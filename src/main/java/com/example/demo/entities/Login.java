
 package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class Login {
    @Id
    private String email;
    private String mdp;
    private  String profile;
	public Login(String email, String mdp, String profile) {
		super();
		this.email = email;
		this.mdp = mdp;
		this.profile = profile;
	}
	public Login() {
		super();
	}
	public Login(String email, String mdp) {
		super();
		this.email = email;
		this.mdp = mdp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}

}
