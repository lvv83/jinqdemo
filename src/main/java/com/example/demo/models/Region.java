package com.example.demo.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "regions")
public class Region implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Getter @Setter
	private Integer id;
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	@ManyToMany(mappedBy = "regions")
	private Set<Territory> territories;
}
