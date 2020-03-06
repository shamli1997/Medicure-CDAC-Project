import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppointmentService } from '../appointment.service';

@Component({
  selector: 'app-patientschedule',
  templateUrl: './patientschedule.component.html',
  styleUrls: ['./patientschedule.component.css']
})
export class PatientscheduleComponent implements OnInit {

  apptlist:any=[];
  pat_id;

  constructor(public router:Router,public apptService:AppointmentService) { }

  

  ngOnInit() {
    this.pat_id=sessionStorage.getItem('userId');
    let resultstate=this.apptService.ViewAppointmentsPat(parseInt(this.pat_id));
    resultstate.subscribe((data)=>{
      this.apptlist = data;

  })

}
}