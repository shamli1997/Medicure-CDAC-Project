package com.app.pojos;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="appointments")
public class Appointment {
	private Integer appt_id;
	
	  private Doctor doctor;
	 
	  private User patient;
	  private Date apptDate;
	  
	 // private List<Slots> slots;
	  private Slots slots;
	  
	  private Integer booked;
	 

	  public Appointment() {
		System.out.println("Appointment pojo created!!");
	}


	

	public Appointment(Doctor doctor, User patient, Date apptDate, Slots slots, Integer booked) {
		super();
		this.doctor = doctor;
		this.patient = patient;
		this.apptDate = apptDate;
		this.slots = slots;
		this.booked = booked;
	}




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getAppt_id() {
		return appt_id;
	}

	public void setAppt_id(Integer appt_id) {
		this.appt_id = appt_id;
	}

	 @ManyToOne
	 @JoinColumn(nullable = false, name = "doc_id")
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	 @ManyToOne
	 @JoinColumn(nullable = false, name = "patient_id")
	public User getPatient() {
		return patient;
	}

	public void setPatient(User patient) {
		this.patient = patient;
	}
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getApptDate() {
		return apptDate;
	}

	public void setApptDate(Date apptDate) {
		this.apptDate = apptDate;
	}

	@ManyToOne
	@JoinColumn(name = "sl_id")
	public Slots getSlots() {
		return slots;
	}


	public void setSlots(Slots slots) {
		this.slots = slots;
	}



	public Integer getBooked() {
		return booked;
	}




	public void setBooked(Integer booked) {
		this.booked = booked;
	}


	@Override
	public String toString() {
		return "Appointment [appt_id=" + appt_id + ", doctor=" + doctor + ", patient=" + patient + ", apptDate="
				+ apptDate + ", slots=" + slots + ", booked=" + booked + "]";
	}


//	@Override
//	public String toString() {
//		return "Appointment [appt_id=" + appt_id + ", apptDate=" + apptDate + ", slots=" + slots + ", booked=" + booked
//				+ "]";
//	}
	
	
	
	
	

	

	
	


	

	
	
	
	  
	  
}
