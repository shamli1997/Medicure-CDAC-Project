package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "doctors")
public class Doctor {

	private Integer doctorId;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String password;
	private QualificationType qualification;
	public Integer flag=1;
	
	//private List<Appointment> 
	
	/* private SpecializationType specialization; */
	  
	 private Specialization specs;
	 
	 
	 

	private City city;

	public Doctor(String firstName) {
		super();
		this.firstName = firstName;
		
	}

	@JsonIgnore
	private List<User> users = new ArrayList<User>();

	public Doctor() {
		System.out.println("Doctor pojo created!!!");
	}

	public Doctor(String firstName, String lastName, String phone, String email, String password,
			QualificationType qualification) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.qualification = qualification;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	@Column(length = 30, nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(length = 30)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(length = 10, unique = true, nullable = false)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(length = 30, unique = true, nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 20, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Enumerated(EnumType.STRING)
	public QualificationType getQualification() {
		return qualification;
	}

	public void setQualification(QualificationType qualification) {
		this.qualification = qualification;
	}

	@ManyToOne

	@JoinColumn(name = "s_id")
	public Specialization getSpecs() {
		return specs;
	}

	public void setSpecs(Specialization specs) {
		this.specs = specs;
	}

	/*
	 * @Enumerated(EnumType.STRING) public SpecializationType getSpecialization() {
	 * return specialization; }
	 * 
	 * public void setSpecialization(SpecializationType specialization) {
	 * this.specialization = specialization; }
	 */

	@ManyToOne
	@JoinColumn(name = "c_id")
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@ManyToMany
	@JoinTable(name = "user_doctors", joinColumns = @JoinColumn(name = "doctor_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", firstName=" + firstName + ", lastName=" + lastName + ", phone="
				+ phone + ", email=" + email + ", qualification=" + qualification + "]";
	}

	

}
