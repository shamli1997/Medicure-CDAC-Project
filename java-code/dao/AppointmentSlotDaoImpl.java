package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Appointment;
import com.app.pojos.City;
//import com.app.pojos.AppointmentSlot;
import com.app.pojos.Doctor;
import com.app.pojos.Slots;

@Repository
@Transactional
public class AppointmentSlotDaoImpl implements IAppointmentSlotDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Slots getById(int slotId) 
	{
		String jpql="select s from Slots s where slot_id=:slotId"; 
		Slots apt= sf.getCurrentSession().createQuery(jpql, Slots.class).
		setParameter("slotId", slotId) .getSingleResult();
		return apt;
	}
	 

	
	  @Override public List<Slots> getapslotlist(Integer doctorId) 
	  {
	  
	  return (List<Slots>) sf.getCurrentSession().get(Slots.class, doctorId); 
	  }



	@Override
	public List<Slots> allSlots() {
		System.out.println("Slots dao");
		String jpql = "select s from Slots s";
		return sf.getCurrentSession().createQuery(jpql,Slots.class).getResultList();
	}



	@Override
	public boolean validateSlot(Appointment ap) {
		System.out.println("Validating slot!!!");
		System.out.println(ap);
		System.out.println("slotId--->"+ ap.getSlots().getSlot_id());
		System.out.println("appDate--->"+ ap.getApptDate());
		System.out.println("doctorId----->"+ ap.getDoctor().getDoctorId());
		
		
		try {
			String jpql="select a from Appointment a where a.slots.slot_id=:slotId"
					+ " and a.apptDate=:appDate and a.doctor.doctorId=:doctorId";
			
			Appointment aps= sf.getCurrentSession().createQuery(jpql,Appointment.class)
					.setParameter("slotId", ap.getSlots().getSlot_id())
					.setParameter("appDate", ap.getApptDate())
					.setParameter("doctorId", ap.getDoctor().getDoctorId()).getSingleResult();
			System.out.println("Success!!!!");
			
		} catch (Exception e) {
			return true;
		}
		return false;

	}
	 
}
