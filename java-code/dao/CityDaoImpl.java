package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.City;
import com.app.pojos.Specialization;

@Repository
@Transactional
public class CityDaoImpl implements ICityDao {

	@Autowired
	private SessionFactory sf;
	@Override
	public List<City> allCities() {
		System.out.println("city dao");
		String jpql = "select c from City c";
		return sf.getCurrentSession().createQuery(jpql,City.class).getResultList();
	}
	
	
	@Override
	public City searchCity(String cityName) {
		System.out.println("Searching city!!!");
		
		String jpql="select c from City c where c.cityName=:cn";
		return sf.getCurrentSession().createQuery(jpql, City.class)
				.setParameter("cn", cityName).getSingleResult();
	}


	@Override
	public List<Specialization> allSpecialization() {
		System.out.println("specialization dao");
		String jpql = "select s from Specialization s";
		return sf.getCurrentSession().createQuery(jpql,Specialization.class).getResultList();
	}

	

}
