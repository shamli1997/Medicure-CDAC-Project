import { Component, OnInit } from '@angular/core';
import { PatientService } from '../patient.service';
import { DoctorService } from '../doctor.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-patientdashboard',
  templateUrl: './patientdashboard.component.html',
  styleUrls: ['./patientdashboard.component.css']
})
export class PatientdashboardComponent implements OnInit {
  cities:any=[];
  city:String="";
  doctors:any;
  doctorSpecs:any;
  data:any;

  no;
  docts:any;

  docts1:any;

  doctorId:any;
  doctorProfile:any;

  spec:string="";
  specializations:any=[];
  cityselected:Number;
  
  constructor(private patservice:PatientService,
              private doctservice:DoctorService,
              private routes:Router,
              private actRoute: ActivatedRoute) { 

               
            
                 
    
  }
  

  
  
   GetDoctorList(cityForm)
   {
     this.doctors=cityForm.form.value;
     this.doctservice.GetData(this.doctors).subscribe((res)=>
     {
       console.log(res)
       this.doctors=res;
       sessionStorage['cityName']=res;
       console.log(this.doctors);
       //this.routes.navigate(['doctorlist']);
     })
    }

    GetDoctorListBySpec(specForm)
   {
     this.doctorSpecs=specForm.form.value;
     this.doctservice.GetSpec(this.doctorSpecs).subscribe((res)=>
     {
       console.log("specs");
       this.doctorSpecs=res;
      
       console.log(this.doctorSpecs);
       //this.routes.navigate(['doctorlist']);
     })
    }

    GetSpecialization()
    {
      let data=this.patservice.GetAllSpecs();
      data.subscribe((res)=>{
        this.specializations=res;
      });
    }


    

  ngOnInit() {
    let resultstate=this.patservice.GetAllCities();
    resultstate.subscribe((data)=>{
      this.cities = data;
     
    });

    let data=this.patservice.GetAllSpecs();
      data.subscribe((res)=>{
        this.specializations=res;
      });
    
  }



}
