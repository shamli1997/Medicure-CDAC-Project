import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-admin-doctors',
  templateUrl: './admin-doctors.component.html',
  styleUrls: ['./admin-doctors.component.css']
})
export class AdminDoctorsComponent implements OnInit {

  doctors:any=[];
  //docts:any=[];
  constructor(public router:Router,public doctService:DoctorService) { }

  updateDoc(doctorId)
  {
    this.router.navigate(['updateDoct',{"key":doctorId}])
  }

  DeleteDoctor(doc)
  {
    //debugger;
   // let data1 = delDocForm.form.value;
    // let doct={
    //   "firstName":data1.firstName,
      
    //   "qualification":data1.qualification,
    //   "flag":1,
    //   "specs":{"spec_id":parseInt(data1.specialization)},
    //   "city":{"city_id":parseInt(data1.city)},
      

    // }
    let resultstate=this.doctService.DeleteDoc(doc);
    resultstate.subscribe((data1)=>{
      alert("Deleted Successfully!!");
      this.doctors = data1;
      console.log(this.doctors);
     
  });
 }

  ngOnInit() {

    let resultstate=this.doctService.GetAllDoct();
    resultstate.subscribe((data)=>{
      this.doctors = data;
     
    });



  }


}
