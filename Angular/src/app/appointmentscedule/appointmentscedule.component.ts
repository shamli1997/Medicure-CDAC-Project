import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AppointmentService } from '../appointment.service';
import { parse } from 'querystring';

@Component({
  selector: 'app-appointmentscedule',
  templateUrl: './appointmentscedule.component.html',
  styleUrls: ['./appointmentscedule.component.css']
})
export class AppointmentsceduleComponent implements OnInit {
  slots1:any=[];
  slot:String="";

  d_id;
  u_id;

 

  data;
  msg:string;
  constructor(public route:Router,public aptServive : AppointmentService,
    public actRoute:ActivatedRoute) 
  { 
    //debugger;
    this.d_id=this.actRoute.snapshot.paramMap.get('key');
  }
  
  BookAppt(aptForm)
  {
    
    let data = aptForm.form.value;
    this.u_id=sessionStorage.getItem('userId');
    console.log(this.u_id);

    var appt={
      "apptDate":data.apptDate,
      "booked":1,
      "doctor":{"doctorId":parseInt(this.d_id)},
      "patient":{"userId":parseInt(this.u_id)},
      "slots":{"slot_id":parseInt(data.slots)}
          }
console.log(appt);
   
    
    this.aptServive.CreateAppointment(appt).subscribe((res)=>{
      debugger;
      this.data=res;   
      console.log("CreateAppt"+this.data);
      console.log(this.data);
      if(this.data)
      this.msg="your appointment is booked";
      else
      this.msg="This Slot is already booked try another slot!!";
     // alert(this.msg);
    
    },(err)=>{
      this.msg="This Slot is already booked try another slot!!";
    })     
  }

  ngOnInit() {
    let resultstate=this.aptServive.GetAllSlots();
    resultstate.subscribe((data)=>
    {
      this.slots1=data;
      console.log(data);
    });
    
  }

}
