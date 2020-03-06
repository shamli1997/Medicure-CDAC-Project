import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-testreport',
  templateUrl: './testreport.component.html',
  styleUrls: ['./testreport.component.css']
})
export class TestreportComponent implements OnInit {

  constructor(public router:Router) { }

  ngOnInit() {
  }

}
