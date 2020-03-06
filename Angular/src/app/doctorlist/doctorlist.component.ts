import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-doctorlist',
  templateUrl: './doctorlist.component.html',
  styleUrls: ['./doctorlist.component.css']
})
export class DoctorlistComponent implements OnInit {

  doctors:any=[];
  
  constructor(public routes:Router,private doctservice:DoctorService) { }

  ngOnInit() {
   
    
  }
  // dropdown.component.ts


 



//   GetDoctorList(city)
//   {
//     console.log(city)
//    this.doctors=city;
//    this.doctservice.GetData(this.doctors).subscribe((res)=>{
//      this.doctors=res;
//      this.routes.navigate(['doctorlist']);
    
//    })

// }
}
