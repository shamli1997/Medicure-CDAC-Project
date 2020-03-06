import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  constructor(public http:HttpClient) { }

  GetAllSlots()
  {
    return this.http.get("http://13.234.21.19:8080/DacAug19/apcnt/slots");
  }

  CreateAppointment(appt)
  {
    console.log(appt);
    //console.log(u_id);
    return this.http.post("http://13.234.21.19:8080/DacAug19/apcnt/bookappointment",appt)
  }

  ViewAppointmentsPat(userId)
  {
    return this.http.get("http://13.234.21.19:8080/DacAug19/apcnt/viewAppointments/"+userId)
  }

  ViewAppointmentsDoc(doctorId){
    return this.http.get("http://13.234.21.19:8080/DacAug19/apcnt/viewdoctSchedule/"+doctorId)
  }
}

