package com.app.dao;

import java.util.List;
import java.util.Random;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Doctor;
import com.app.pojos.QualificationType;
import com.app.pojos.User;
import com.app.pojos.UserType;

@Service
@Transactional
public class IUserDaoImpl implements IUserDao {
	
	@Autowired
	SessionFactory sf;

	@Override
	public Integer registerUser(User user) {
		return (Integer) sf.getCurrentSession().save(user);
	}

	@Override
	public User login(User user) {

		String jpql = "select u from User u where u.email = :em and u.password=:pass";
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", user.getEmail())
				.setParameter("pass", user.getPassword()).getSingleResult();

	}

	@Override
	public User findByEmail(User user) {
		System.out.println(user);
		String jpql = "select u from User u where u.email=:em";
		return sf.getCurrentSession().createQuery(jpql,User.class).setParameter("em",user.getEmail()).getSingleResult();
	}

	@Override
	public User findByEmail(String email) {
System.out.println("we find email as "+email);
		
		String jpql = "select u from User u where u.email=:em";
		return sf.getCurrentSession().createQuery(jpql,User.class).setParameter("em",email).getSingleResult();
	}

	@Override
	public int generateOtp() {
		Random random = new Random();
		int num = random.nextInt(99999) + 99999;
		if (num < 100000 || num > 999999) 
		{
			num = random.nextInt(99999) + 99999;
			if (num < 100000 || num > 999999)
			{
				System.out.println("Unable to generate PIN at this time..");
			}
		}
		return num;
	}

	@Override
	public int resetpassword(String email, String pass) {
		User u = findByEmail(email);
		System.out.println(u);
		if(u!=null)
		{
			u.setPassword(pass);
			return 1;
		}
		else
			return 0;
	}

	@Override
	public void updateOtp(User user) {
		sf.getCurrentSession().update(user);
		
	}

	@Override
	public List<UserType> listUserRoles() {
		String jpql="select distinct d.role from User d";
		List<UserType>list=sf.getCurrentSession().createQuery(jpql,UserType.class).getResultList();
		System.out.println(list);
		return list;
	}
	
	

}
