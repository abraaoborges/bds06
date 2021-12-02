package com.devsuperior.movieflix.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;

import com.devsuperior.movieflix.entities.User;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	@Email(message = "Favor entrar com e-mail válido")
	private String email;
	
//	Set<RoleDTO> roles = new HashSet<>();
	
	public UserDTO(){
		
	}

	public UserDTO(Long id,String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;		
		this.email = email;
	}
	
	public UserDTO(User entity) {
		super();
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
//		entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

//	public Set<RoleDTO> getRoles() {
//		return roles;
//	}
}
