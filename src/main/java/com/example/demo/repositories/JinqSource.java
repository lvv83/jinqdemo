package com.example.demo.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.jinq.jpa.JPAJinqStream;
import org.jinq.jpa.JinqJPAStreamProvider;
import org.springframework.stereotype.Component;

import com.example.demo.models.Region;
import com.example.demo.models.Territory;

// http://www.jinq.org/docs/spring.html#N65612

@Component
public class JinqSource {
	private JinqJPAStreamProvider streamProvider;

	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		streamProvider = new JinqJPAStreamProvider(emf);
		streamProvider.setHint("exceptionOnTranslationFail", true);
	}

	
	public <T> JPAJinqStream<T> streamAll(EntityManager em, Class<T> entity) {
		return streamProvider.streamAll(em, entity);
	}
	
	public JPAJinqStream<Territory> territories(EntityManager em) {
		return streamProvider.streamAll(em, Territory.class);
	}
	
	public JPAJinqStream<Region> regions(EntityManager em) {
		return streamProvider.streamAll(em, Region.class);
	}
}
