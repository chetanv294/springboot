package com.developerstack.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chetan.users.model.User;
import com.developerstack.dao.impl.UserDao;
import com.developerstack.model.UserDetails;

@Component("userDetailDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<UserDetails> getUserDetails() {
		Criteria criteria = sessionFactory.openSession().createCriteria(UserDetails.class);
		return criteria.list();
	}

	public UserDetails findUserByEmail(String email) {
		UserDetails userDetails = null;
		Criteria criteria = sessionFactory.openSession().createCriteria(UserDetails.class);
		criteria.add(Restrictions.eq("email", email));
		List<UserDetails> entityList = criteria.list();
		if(!entityList.isEmpty()) {
			userDetails = entityList.get(0);
		}
		return userDetails;
	}
	
	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();

		users = sessionFactory.getCurrentSession()
			.createQuery("from User where username=?")
			.setParameter(0, username)
			.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

}
