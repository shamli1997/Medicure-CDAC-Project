import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  roles:any=[];
  role:String="";
  constructor(public router:Router,private userService:UserService) { }

  register(myForm)
  {
    let data=myForm.form.value;
    this.userService.register(data).subscribe((res)=>{
      this.router.navigate(['login']);
    },(error)=>{

    }
    )
  }
  ngOnInit() {
    let roleUser=this.userService.GetRole();
    roleUser.subscribe((q)=>{
      console.log(q);
      this.roles=q;
    });
  }

}
