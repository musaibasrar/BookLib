package com.bookan.book.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookan.book.domain.User;

@Repository
public class UserDAOImp implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User readUniqueObject(User user) {
		User userOne =null;
		Session session = this.sessionFactory.getCurrentSession();
		 Query query = session.createQuery("FROM User as user where user.name= :loginName and user.password= :password");
         query.setParameter("loginName", user.getName());
         query.setParameter("password", user.getPassword());
         userOne = (User) query.uniqueResult();
		return userOne;
	}

}
