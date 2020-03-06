import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }


  register(user){

    return this.http.post("http://13.234.21.19:8080/DacAug19/user/register",user);

  }

   login(user)
  {
    return this.http.post("http://13.234.21.19:8080/DacAug19/user/login",user);
   }

   doclogin(doctor)
   {
     return this.http.post("http://13.234.21.19:8080/DacAug19/doctor/login",doctor)
   }

   forgot(user)
  {
    console.log(user);
    return this.http.post("http://13.234.21.19:8080/DacAug19/user/forgot",user);
  }

  otp(user,email)
  {
    console.log(user);
    return this.http.post("http://13.234.21.19:8080/DacAug19/user/otp?email="+email,user);
  }

  address(email,x)
  {
    return this.http.put("http://13.234.21.19:8080/DacAug19/user/address?email="+email,x);
  }

  change(data,email)
  {
    console.log(data);
    return this.http.post("http://13.234.21.19:8080/DacAug19/user/change?email="+email,data);
  }

  GetRole()
  {
    return this.http.get("http://13.234.21.19:8080/DacAug19/user/role");
  }


}
