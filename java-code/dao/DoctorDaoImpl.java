package com.app.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.City;
import com.app.pojos.Doctor;
import com.app.pojos.QualificationType;
import com.app.pojos.User;


@Repository
@Transactional
public class DoctorDaoImpl implements IDoctorDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Doctor login(Doctor doctor) {

		String jpql = "select d from Doctor d where d.email = :em and d.password=:pass";
		return sf.getCurrentSession().createQuery(jpql, Doctor.class).setParameter("em", doctor.getEmail())
				.setParameter("pass", doctor.getPassword()).getSingleResult();

	}

	@Override
	public List<Doctor> listDoctors(String cityName) {

		
		  String jpql1 = "select c.city_id from City c where c.cityName=:CITY"; int
		  cityid = sf.getCurrentSession().createQuery(jpql1,
		  Integer.class).setParameter("CITY", cityName) .getSingleResult();
		  System.out.println(cityid);
		 
		System.out.println("Searching doctor!!");
		String jpql = "select d from Doctor d where c_id=:city_id";
		//String jpql="select d from Doctors d outer join fetch Specializations s where d.c_id=:city_id and d.s_id=1";
		List <Doctor> doct=sf.getCurrentSession().createQuery(jpql, Doctor.class).
				setParameter("city_id", cityid).getResultList();
		for(Doctor doctor :doct)
		{
			System.out.println(doctor);
			System.out.println(doctor.getSpecs().getSpecialization());
		}
		return doct;

	}


	@Override
	public List<Doctor> listBySpecs(String spec) {
		String jpql1 = "select s.spec_id from Specialization s where s.specialization=:spec"; 
		int specid = sf.getCurrentSession().createQuery(jpql1,
		  Integer.class).setParameter("spec", spec) .getSingleResult();
		  System.out.println(specid);
		 
		System.out.println("Searching doctor by specialization!!");
		String jpql = "select d from Doctor d where s_id=:spec_id";
		//String jpql="select d from Doctors d outer join fetch Specializations s where d.c_id=:city_id and d.s_id=1";
		return sf.getCurrentSession().createQuery(jpql, Doctor.class).
				setParameter("spec_id", specid).getResultList();
	}


	@Override
	public Doctor doctorProfile(int doctorId) {
		String jpql="select d from Doctor d where doctorId=:doctorId";
		Doctor doct= sf.getCurrentSession().createQuery(jpql, Doctor.class).
				setParameter("doctorId", doctorId)
				.getSingleResult();
		System.out.println(doct + " "+doct.getSpecs().getSpecialization());
		
		return doct;
		
	}

	@Override
	public String registerDoctor(Doctor doc) {
		System.out.println(doc);
		System.out.println(doc.getFirstName());
		sf.getCurrentSession().save(doc);
		return "doctor added successfully";
	}

	@Override
	public String deleteDoctorDetails(Doctor doc) {
		String mesg="Doctor with ID : " + doc.getDoctorId() + " deletion succeeded";

	doc.setFlag(0);
	sf.getCurrentSession().update(doc);
	return mesg;
	}

	@Override
	public Doctor getUserDetails(int doctorId) {
		System.out.println("inside getUserDetails"+sf.getCurrentSession().get(Doctor.class,doctorId));
		return sf.getCurrentSession().get(Doctor.class,doctorId);
	}

	@Override
	public void updateDoctorDetails(Doctor doc) {
		sf.getCurrentSession().save(doc);
		
	}

	@Override
	public List<QualificationType> listQualifications() {
		String jpql="select distinct d.qualification from Doctor d";
		return sf.getCurrentSession().createQuery(jpql,QualificationType.class).getResultList();
	}

	@Override
	public List<Doctor> listAllDoctors() {
		String jpql="select d from Doctor d";
		return sf.getCurrentSession().createQuery(jpql,Doctor.class).getResultList();
		
	}

	@Override
	public List<Doctor> displayDoctorAfterDeletion() {
		String jpql="select d from Doctor d where d.flag=1";
		return sf.getCurrentSession().createQuery(jpql,Doctor.class).getResultList();
	}

	@Override
	public String deletedoctorInfo(Doctor d) {
		sf.getCurrentSession().delete(d);
		return "Deleted emp info";
	}

	@Override
	public String updateDoctDetails(Doctor e) {
		Session hs=sf.getCurrentSession();
		hs.clear();//clears cache
		hs.update(e);//e --persistent
		return "Doctor details updated....";
		
	}
	
	

}
