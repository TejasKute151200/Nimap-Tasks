package com.springrestapi.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
@Where(clause = "is_active=true")
@SQLDelete(sql = "UPDATE student SET is_active=false WHERE id=?")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotBlank(message = "Name is mandatory")
	@Column(name = "student_name")
	private String name;
	
	@Email
	@NotBlank(message = "Name is mandatory")
	@Column(name = "email",unique=true)
	private String email;

	@Column(name = "is_active")
	@JsonIgnore
	private Boolean isActive = true;

}
