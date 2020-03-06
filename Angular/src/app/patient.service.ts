import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private http:HttpClient) { }

  GetAllCities()
  {
   return this.http.get("http://13.234.21.19:8080/DacAug19/patient/searchcity");
  }

  GetAllSpecs()
  {
    return this.http.get("http://13.234.21.19:8080/DacAug19/patient/searchspec");
  }
}
