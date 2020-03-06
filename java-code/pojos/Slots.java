package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "slots")
public class Slots {
	
	private Integer slot_id;
	private String slots;
	
	@JsonBackReference
	private List<Appointment> appts=new ArrayList<Appointment>();
	public Slots() {
		System.out.println("Slots pojo");
	}
	
	
	
	public Slots(Integer slot_id, String slots) {
		super();
		this.slot_id = slot_id;
		this.slots = slots;
		
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getSlot_id() {
		return slot_id;
	}
	public void setSlot_id(Integer slot_id) {
		this.slot_id = slot_id;
	}
	public String getSlots() {
		return slots;
	}
	public void setSlots(String slots) {
		this.slots = slots;
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "slots",fetch = FetchType.EAGER)
	public List<Appointment> getAppts() {
		return appts;
	}

	public void setAppts(List<Appointment> appts) {
		this.appts = appts;
	}

	@Override
	public String toString() {
		return "Slots [slot_id=" + slot_id + ", slots=" + slots + "]";
	}

	
	
	
	
	
	
	
	
	

}
