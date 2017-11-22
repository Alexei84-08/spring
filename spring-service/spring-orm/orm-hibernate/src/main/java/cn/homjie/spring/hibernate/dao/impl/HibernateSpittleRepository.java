package cn.homjie.spring.hibernate.dao.impl;

import cn.homjie.spring.hibernate.dao.SpittleRepository;
import cn.homjie.spring.hibernate.domain.Spitter;
import cn.homjie.spring.hibernate.domain.Spittle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class HibernateSpittleRepository implements SpittleRepository {

	private SessionFactory sessionFactory;

	@Autowired
	public HibernateSpittleRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public long count() {
		return findAll().size();
	}

	public List<Spittle> findRecent() {
		return findRecent(10);
	}

	public List<Spittle> findRecent(int count) {
		String hql = "from Spittle order by postedTime desc";
		Query<Spittle> query = currentSession().createQuery(hql, Spittle.class);
		query.setMaxResults(count);
		return query.list();
	}

	public Spittle findOne(long id) {
		return currentSession().get(Spittle.class, id);
	}

	public Spittle save(Spittle spittle) {
		Serializable id = currentSession().save(spittle);
		return new Spittle(
				(Long) id,
				spittle.getSpitter(),
				spittle.getMessage(),
				spittle.getPostedTime());
	}

	public List<Spittle> findBySpitterId(long spitterId) {
		String hql = "from Spittle where spitter = :spitter order by postedTime desc";
		Query<Spittle> query = currentSession().createQuery(hql, Spittle.class);
		query.setParameter("spitter", new Spitter(spitterId));
		return query.list();
	}

	public void delete(long id) {
		currentSession().delete(findOne(id));
	}

	public List<Spittle> findAll() {
		String hql = "from Spittle order by postedTime desc";
		return currentSession().createQuery(hql, Spittle.class).list();
	}

}
