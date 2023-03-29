package com.example.demo.repositories;

import java.util.List;

import com.example.demo.models.Region;

public interface RegionsRepository /*extends JpaRepository<Region, Integer>*/ {
	//@Query("SELECT r FROM Region r WHERE r.id = 1")
	List<Region> customFindMethod();
}
