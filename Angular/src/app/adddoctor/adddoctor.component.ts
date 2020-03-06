import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PatientService } from '../patient.service';
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-adddoctor',
  templateUrl: './adddoctor.component.html',
  styleUrls: ['./adddoctor.component.css']
})
export class AdddoctorComponent implements OnInit {
  cities:any;
  city:any;

  quals:any=[];
  qual:String="";

  spec:any;
  specializations:any;

  constructor(public router:Router,public patservice:PatientService,
    public doctService:DoctorService) { }

  ngOnInit() {
    let resultstate=this.patservice.GetAllCities();
    resultstate.subscribe((data)=>{
      this.cities = data;
      console.log(this.cities);
      
     
    });

    let data=this.patservice.GetAllSpecs();
      data.subscribe((res)=>{
        this.specializations=res;
      });

      let qualification=this.doctService.GetQualification();
      qualification.subscribe((q)=>{
        console.log(q);
        this.quals=q;
      });
  }

  register(regDocForm)
  {
    
    let data1 = regDocForm.form.value;
    var appt={
      "firstName":data1.firstName,
      "lastName":data1.lastName,
      "email":data1.email,
      "phone":data1.phone,
      "password":data1.password,
      "qualification":data1.qualification,
      "city":{"city_id":parseInt(data1.city)},
      "specs":{"spec_id":parseInt(data1.specialization)}
      
          }
          //alert(appt);
          console.log(appt);

    //debugger;
   // let data=regDocForm.form.value;
    this.doctService.AddDoc(appt).subscribe((res)=>{
      console.log(appt);
      console.log(res);

    alert("Doctor added successfully");
      //this.router.navigate(['login']);
    },(error)=>{

    }
    )
  }

}
