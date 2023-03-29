package com.example.demo.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jinq.jpa.JPQL;
import org.jinq.orm.stream.JinqStream;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.Region;
import com.example.demo.models.Territory;

// See @EnableJpaRepositories in DemoApplication
// Postfix = JinqImpl

public class TerritoriesRepositoryJinqImpl implements CustomTerritoryQueries {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private JinqSource jinqSource;
	
	@Override
	public List<Territory> filterByName(String name) {
		
		// TODO: Null reference check
		
		// Find territories by name 
		// or
		// territories in regions by name
		
		// Can not use stream in another stream due serialization error
		/*
		JPAJinqStream<Integer> ids = jinqSource.regions(em)
				.where(r -> JPQL.like(r.getName(), name + "%"))
				.selectAll(reg ->  JinqStream.from(reg.getTerritories()))
				.select(t -> t.getId());
		
		*/
		
		// Postgresql LIKE/ILIKE problem
		final String name2 = name.toLowerCase();
		
		// JINQ doesn't support EXISTS 
		
		return jinqSource.territories(em)
				// use source as second parameter (See InQueryStreamSource for details)
				.where((x, source) -> JPQL.like(x.getName().toLowerCase(), name2 + "%") || 
						JPQL.isIn(x.getId(),
								source.stream(Region.class)
								.where(reg -> JPQL.like(reg.getName().toLowerCase(), name2 + "%"))
								//.selectAllList(reg ->  reg.getTerritories())
								// -- OR INSTEAD .selectAllList
								.selectAll(reg -> JinqStream.from(reg.getTerritories()))
								.select(ter -> ter.getId())
						)
					)
				.toList();
	}

}
