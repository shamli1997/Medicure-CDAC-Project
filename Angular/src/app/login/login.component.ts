import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { EmtrService } from '../emtr.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user;
  id;
  constructor(public router:Router,private userService:UserService,
    private emService:EmtrService) { }

  login(loginForm)
  {
    let data = loginForm.form.value;
   this.userService.login(data).subscribe(res=>{
    this.user=res;
    sessionStorage['email']=res['email'];
    sessionStorage['userId']=res['userId'];
    this.emService.logInBtnSwitch(true);
    this.router.navigate(['home']);

    if(this.user!=null)
    {
     
      if(this.user.role=="PATIENT")
      {
      this.router.navigate(['patientdashboard']);
      }
      else
      {
         this.router.navigate(['admindoc']);
      }
    }

   },(err)=>{

    alert("Username/password is wrong!!");
   })
  }
  ngOnInit() {
  }

}
