package com.rinq.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario{	

	private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Id
	private String cpf;
	private String password;
	private String name;
	private String email;
	
	public Usuario() {}
	
	public Usuario(DataTransferObject OTD) {
		this.setCpf(OTD.getCpf());
		this.setPassword(OTD.getPassword());
		this.setName(OTD.getName());
		this.setEmail(OTD.getEmail());
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {		
		this.password = passwordEncoder.encode(password);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
