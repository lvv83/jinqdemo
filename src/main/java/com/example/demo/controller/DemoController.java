package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Region;
import com.example.demo.models.Territory;
import com.example.demo.repositories.RegionsRepository;
import com.example.demo.repositories.TerritoriesRepository;

@RestController
public class DemoController {

	@Autowired
	private TerritoriesRepository territoriesRepository;
	
	@Autowired
	private RegionsRepository regionsRepository;
	
	@GetMapping("/territories")
	List<Territory> territories()
	{
		return territoriesRepository.findAll();
	}
	
	@GetMapping("/territories2")
	List<Territory> territoriesWithJINQ(String name)
	{
		return territoriesRepository.filterByName(name);
	}
	
	@GetMapping("/regions")
	List<Region> regions()
	{
		return regionsRepository.customFindMethod();
	}
}
