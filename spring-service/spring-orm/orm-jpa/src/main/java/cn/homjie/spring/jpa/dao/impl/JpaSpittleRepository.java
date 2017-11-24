package cn.homjie.spring.jpa.dao.impl;

import cn.homjie.spring.jpa.dao.SpittleRepository;
import cn.homjie.spring.jpa.domain.Spitter;
import cn.homjie.spring.jpa.domain.Spittle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class JpaSpittleRepository implements SpittleRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public long count() {
		return findAll().size();
	}

	public List<Spittle> findRecent() {
		return findRecent(10);
	}

	public List<Spittle> findRecent(int count) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Spittle> query = builder.createQuery(Spittle.class);
		Root<Spittle> root = query.from(Spittle.class);
		query.select(root).orderBy(builder.desc(root.get("postedTime")));
		return entityManager.createQuery(query).setMaxResults(count).getResultList();
	}

	public Spittle findOne(long id) {
		return entityManager.find(Spittle.class, id);
	}

	public Spittle save(Spittle spittle) {
		entityManager.persist(spittle);
		return spittle;
	}

	public List<Spittle> findBySpitterId(long spitterId) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Spittle> query = builder.createQuery(Spittle.class);

		Root<Spittle> spittleRoot = query.from(Spittle.class);
		Root<Spitter> spitterRoot = query.from(Spitter.class);

		query.select(spittleRoot);

		Predicate join = builder.equal(spittleRoot.get("spitter"), spitterRoot.get("id"));
		Predicate spitterRootId = builder.equal(spitterRoot.get("id"), spitterId);

		query.where(builder.and(join, spitterRootId)).orderBy(builder.desc(spittleRoot.get("postedTime")));
		return entityManager.createQuery(query).getResultList();
	}

	public void delete(long id) {
		entityManager.remove(findOne(id));
	}

	public List<Spittle> findAll() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Spittle> query = builder.createQuery(Spittle.class);

		query.select(query.from(Spittle.class));

		return entityManager.createQuery(query).getResultList();
	}

}
