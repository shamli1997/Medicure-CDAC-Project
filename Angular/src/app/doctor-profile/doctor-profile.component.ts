import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { DoctorService } from '../doctor.service';
import { error } from 'util';
import { Doctor } from './doctor';

@Component({
  selector: 'app-doctor-profile',
  templateUrl: './doctor-profile.component.html',
  styleUrls: ['./doctor-profile.component.css']
})
export class DoctorProfileComponent implements OnInit {

  

  doctorId:any;
  doctorProfile:any;
  constructor(public router:Router,private doctservice:DoctorService,
    private actRoute: ActivatedRoute) 
    {
      
      
      
    }

    goToBooking(d)
    {
      //alert(d);
      this.router.navigate(['appointment',{"key":d}]);
      
    }
  ngOnInit() 
  {
    this.doctorId=this.actRoute.snapshot.params['doctorId'];
    //alert(this.doctorId);
 this.loadDoctorProfile(this.doctorId);
  }

  loadDoctorProfile(doctorId)
  {
    this.doctservice.GetProfile(doctorId).subscribe((doctor)=>{
      this.doctorProfile = doctor;
      console.log(this.doctorProfile);
    });
    
  }


}