import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  baseUrl="http://13.234.21.19:8080/DacAug19/admin/update"

  constructor(public http: HttpClient) { }

  GetData(city:any)
  {
   return this.http.post("http://13.234.21.19:8080/DacAug19/doctor/searchdoct",city);
   
  }

  GetSpec(spec:any)
  {
    return this.http.post("http://13.234.21.19:8080/DacAug19/doctor/searchdoctByspec",spec);
  }

  GetProfile(id)
  {
    return this.http.get("http://13.234.21.19:8080/DacAug19/doctor/doctorprofile?doctorId="+id);
  }

  AddDoc(doc)
  {
    
    return this.http.post("http://13.234.21.19:8080/DacAug19/admin/register",doc);
  }
  GetQualification(){
    return this.http.get("http://13.234.21.19:8080/DacAug19/doctor/qualifications");
  }

  GetAllDoct(){
    return this.http.get("http://13.234.21.19:8080/DacAug19/admin/listdoctors");
  }

  DeleteDoc(doc)
  {
    return this.http.post("http://13.234.21.19:8080/DacAug19/admin/deletedoctor",doc);
  }

  getDataById(doctorId){

    return this.http.get("http://13.234.21.19:8080/DacAug19/admin/list/"+doctorId);

   }


  update(doct)
  {
    // console.log("Updated Data: "+doct.firstName);
    // const formData = new FormData();
    // formData.append("email",doct.email);
    // formData.append("firstName",doct.firstName);
    // formData.append("phone",doct.phone);
    
    // console.log(formData);
    return this.http.put("http://13.234.21.19:8080/DacAug19/admin/update/"+doct.doctorId,doct);
  }
 
}
