import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-update-doct',
  templateUrl: './update-doct.component.html',
  styleUrls: ['./update-doct.component.css']
})
export class UpdateDoctComponent implements OnInit {
did;
doct;
doctorId;
  constructor(public router:Router,public activeRoute:ActivatedRoute,
    public doctservice:DoctorService) {
      this.did=this.activeRoute.snapshot.paramMap.get('key')
      activeRoute.paramMap.subscribe((params)=>{
        this.doctorId=this.did;
  
        this.doctservice.getDataById(this.doctorId).subscribe((res)=>{
  
          console.log(res);
          this.doct=res;
          
          console.log(this.doct);
  
        })
  
  
      })
     }

     update()
     {
       //debugger;
       alert("Updated Succesfully!!")
      this.doct.doctorId=parseInt(this.doctorId);
      this.doctservice.update(this.doct).subscribe((res)=>{
        console.log(res);
        this.router.navigate(['admindoc']);
   
      })
   
     }

  ngOnInit() {
  }

}
