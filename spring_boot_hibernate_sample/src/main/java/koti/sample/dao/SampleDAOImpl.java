package koti.sample.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import koti.sample.entity.User;

@Repository("sampleDao")
public class SampleDAOImpl implements SampleDAO{

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession(){
		if(sessionFactory != null){
			if (!sessionFactory.getCurrentSession().isOpen()) {
				return sessionFactory.openSession();
			} else {
				return sessionFactory.getCurrentSession();
			}
		}
		return null;
	}

	@Override
	public void storeData(Object user) {
		getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public User fetchUser(String id) {
		Criteria criteria = getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("id", id));
		User result = (User) (criteria.list() != null && !criteria.list().isEmpty() ? criteria.list().get(0) : null);
		return result;
	}

}
