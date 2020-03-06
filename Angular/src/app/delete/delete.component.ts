import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {
  doctors:any=[];
  constructor(public router:Router, public doctService:DoctorService ) { }

  

  
  ngOnInit() {
    //let data1 = delDocForm.form.value;
  
            }

}
