package cn.homjie.spring.data.dao;

import cn.homjie.spring.data.domain.Spittle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class SpittleRepositoryImpl implements SpittleRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Spittle> findRecent() {
		return findRecent(10);
	}

	public List<Spittle> findRecent(int count) {
		String sql = "select s from Spittle s order by s.postedTime desc";
		return entityManager.createQuery(sql, Spittle.class)
				.setMaxResults(count)
				.getResultList();
	}

}
