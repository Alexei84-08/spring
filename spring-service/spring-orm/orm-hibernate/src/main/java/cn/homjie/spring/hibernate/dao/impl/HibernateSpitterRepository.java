package cn.homjie.spring.hibernate.dao.impl;

import cn.homjie.spring.hibernate.dao.SpitterRepository;
import cn.homjie.spring.hibernate.domain.Spitter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class HibernateSpitterRepository implements SpitterRepository {

	private SessionFactory sessionFactory;

	@Autowired
	public HibernateSpitterRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public long count() {
		return findAll().size();
	}

	public Spitter save(Spitter spitter) {
		Serializable id = currentSession().save(spitter);
		return new Spitter((Long) id,
				spitter.getUsername(),
				spitter.getPassword(),
				spitter.getFullName(),
				spitter.getEmail(),
				spitter.isUpdateByEmail());
	}

	public Spitter findOne(long id) {
		return currentSession().get(Spitter.class, id);
	}

	public Spitter findByUsername(String username) {
		String hql = "from Spitter where username = :username";
		Query<Spitter> query = currentSession().createQuery(hql, Spitter.class);
		query.setParameter("username", username);
		return query.list().get(0);
	}

	public List<Spitter> findAll() {
		return currentSession().createQuery("from Spitter", Spitter.class).list();
	}

}
