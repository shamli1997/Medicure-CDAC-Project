
  package com.app.pojos;
  
  import java.util.ArrayList; import java.util.List;
  
  import javax.persistence.CascadeType; import javax.persistence.Column; import
  javax.persistence.Entity; import javax.persistence.FetchType; import
  javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
  import javax.persistence.Id; import javax.persistence.OneToMany; import
  javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
  
  @Entity
  
  @Table(name = "specializations") 
  public class Specialization 
  { 
	  private Integer spec_id; 
	  private String specialization;
  
  @JsonBackReference
  private List<Doctor> doctors=new ArrayList<>();
  
  public Specialization()
  { 
	  System.out.println("Specilization pojo created!!");
  }
  
  
  public Specialization( String specialization)
  { super();
  
  this.specialization = specialization; 
  }
  
  @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getSpec_id()
  { 
	  return spec_id;
  }
  
  public void setSpec_id(Integer spec_id)
  {
	  this.spec_id = spec_id; 
	  }
  
  @Column(length = 50)
  public String getSpecialization() 
  { 
	  return specialization; 
  }
  
  public void setSpecialization(String specialization) 
  { 
	  this.specialization =specialization;
	  }
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "specs",fetch =
  FetchType.EAGER) 
  public List<Doctor> getDoctors()
  {
	  return doctors; 
	  }
  
  
  public void setDoctors(List<Doctor> doctors) 
  { 
	  this.doctors = doctors;
	  }
  
  
  @Override public String toString() 
  { 
	  return "Specialization [spec_id=" +
  spec_id + ", specialization=" + specialization + "]"; 
  }
  
  
  
  }
 