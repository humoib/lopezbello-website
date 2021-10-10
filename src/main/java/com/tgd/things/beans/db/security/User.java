package com.tgd.things.beans.db.security;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
// In PostgreSQL, "user" is a system table
@Table(name = "USERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;
	
	private String fullname;

	private String password;

	private String email;
	
	@Transient
	private String passwordConfirm;

	@ManyToMany
	private Set<Role> roles;

	@ManyToMany
	private Set<Group> groups;
}
