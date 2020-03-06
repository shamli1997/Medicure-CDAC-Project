import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { EmtrService } from '../emtr.service';

@Component({
  selector: 'app-doclogin',
  templateUrl: './doclogin.component.html',
  styleUrls: ['./doclogin.component.css']
})
export class DocloginComponent implements OnInit {

  constructor(public router:Router,public userService:UserService,
    public emService:EmtrService) { }

  login(docloginForm)
  {
    let data = docloginForm.form.value;
   this.userService.doclogin(data).subscribe(res=>{
    sessionStorage['email']=res['email'];
    sessionStorage['doctorId']=res['doctorId'];
    this.emService.logInBtnSwitch(true);
    this.router.navigate(['doctordashboard']);

   },(err)=>{

    alert("Something went wrong");
   })
  }
  ngOnInit() {
  }

}
