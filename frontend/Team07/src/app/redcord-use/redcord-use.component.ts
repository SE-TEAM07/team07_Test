import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from "@angular/router";
import { ActivatedRoute } from "@angular/router";

// import service 
import { RegisterService } from '../Service/register.service';  // get initial gender bloodtype all
import { CategoryService } from '../Service/category.service'; // get category all
import { RedcorduseService } from '../Service/redcorduse.service';  // get Customer by Id


@Component({
  selector: 'app-redcord-use',
  templateUrl: './redcord-use.component.html',
  styleUrls: ['./redcord-use.component.css']
})
export class RedcordUseComponent implements OnInit {
  // get data from db  
  category: Array<any>;
  categoryselect = '';
  Iinitials: Array<any>;
  Initialselect = '';
  genders: Array<any>;
  genderselect = '';
  bloodtypes: Array<any>;
  bloodtypeselect = '';
  customer: Array<any>;
  customerselect = '';

  data: any = {}
  datas: any = {}

  constructor(private route: ActivatedRoute, private redcorduseservice: RedcorduseService, private registerservice: RegisterService, private router: Router, private categoryservice: CategoryService, private httpClient: HttpClient) { }


  ngOnInit() {
    this.route.params.subscribe(prams => {
      this.datas = prams
      console.log(prams)
    })
    this.categoryservice.getCategory().subscribe(data => {
      this.category = data;
      console.log(this.category)
    })
    this.registerservice.getInitials().subscribe(data => {
      this.Iinitials = data;
      console.log(this.Iinitials)
    })
    this.registerservice.getGenders().subscribe(data => {
      this.bloodtypes = data;
      console.log(this.bloodtypes)
    })
    this.redcorduseservice.getCustomerById(Number(1)).subscribe(data => {
      this.customer = data;
      console.log(this.customer)
    })
  }

}
