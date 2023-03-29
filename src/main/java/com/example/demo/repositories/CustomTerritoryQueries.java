package com.example.demo.repositories;

import java.util.List;

import com.example.demo.models.Territory;

public interface CustomTerritoryQueries {
	List<Territory> filterByName(String name);
}
