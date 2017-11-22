package cn.homjie.spring.hibernate.dao.impl;

import cn.homjie.spring.hibernate.dao.SpittleRepository;
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
		return sessionFactory.getCurrentSession();//<co id="co_RetrieveCurrentSession"/>
	}

	public long count() {
		return findAll().size();
	}

	public List<Spittle> findRecent() {
		return findRecent(10);
	}

	public List<Spittle> findRecent(int count) {
		Query query = currentSession().createQuery("from Spittle order by postedTime desc");
		query.setMaxResults(count);
		return query.list();
	}

	public Spittle findOne(long id) {
		return (Spittle) currentSession().get(Spittle.class, id);
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
		Query query = currentSession().createQuery("from Spittle where spitter = :spitterId");
		query.setParameter("spitterId", spitterId);
		return query.list();
	}

	public void delete(long id) {
		currentSession().delete(findOne(id));
	}

	public List<Spittle> findAll() {
		return currentSession().createQuery("from Spittle order by postedTime desc").list();
	}

}
