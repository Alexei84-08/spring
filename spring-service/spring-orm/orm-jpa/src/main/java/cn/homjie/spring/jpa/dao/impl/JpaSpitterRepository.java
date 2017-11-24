package cn.homjie.spring.jpa.dao.impl;

import cn.homjie.spring.jpa.dao.SpitterRepository;
import cn.homjie.spring.jpa.domain.Spitter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaSpitterRepository implements SpitterRepository {

	// @PersistenceContext annotation is inject the EntityManager object

	@PersistenceContext
	private EntityManager entityManager;

	public long count() {
		return findAll().size();
	}

	public Spitter save(Spitter spitter) {
		entityManager.persist(spitter);
		return spitter;
	}

	public Spitter findOne(long id) {
		return entityManager.find(Spitter.class, id);
	}

	public Spitter findByUsername(String username) {
		String sql = "select s from Spitter s where s.username=?";
		return entityManager.createQuery(sql, Spitter.class).setParameter(0, username).getSingleResult();
	}

	public List<Spitter> findAll() {
		return entityManager.createQuery("select s from Spitter s", Spitter.class).getResultList();
	}

}
