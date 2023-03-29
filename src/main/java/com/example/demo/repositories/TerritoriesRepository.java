package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Territory;

public interface TerritoriesRepository 
	extends JpaRepository<Territory, Integer>, CustomTerritoryQueries {

}
