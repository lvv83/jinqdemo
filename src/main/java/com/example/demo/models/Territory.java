package com.example.demo.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "territories")
public class Territory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Getter @Setter
	private Integer id;
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	@ManyToMany
	@JoinTable(name = "ter_reg", 
		joinColumns = @JoinColumn(name = "ter_id"),
		inverseJoinColumns = @JoinColumn(name = "reg_id")
	)
	@JsonIgnore // Disable JSON reference
	private Set<Region> regions;
}
