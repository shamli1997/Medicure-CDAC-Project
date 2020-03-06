import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppointmentService } from '../appointment.service';

@Component({
  selector: 'app-doctorboard',
  templateUrl: './doctorboard.component.html',
  styleUrls: ['./doctorboard.component.css']
})
export class DoctorboardComponent implements OnInit {
patList:any=[]
  doc_Id;
  constructor(public router:Router,public apptService:AppointmentService) { }

  ngOnInit() {
    this.doc_Id=sessionStorage.getItem('doctorId');
    let resultstate=this.apptService.ViewAppointmentsDoc(parseInt(this.doc_Id));
    resultstate.subscribe((data)=>{
      this.patList = data;

  });

}

}