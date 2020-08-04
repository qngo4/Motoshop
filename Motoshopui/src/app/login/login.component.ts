import { Component, OnInit } from '@angular/core';
import { RestapiService } from '../restapi.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username : String;
  password : String;
  message : any
  constructor(private service: RestapiService, private router: Router) { }

  ngOnInit(): void {
  }
  doLogin(){
    alert("check" + this.username + this.password);
    let resp = this.service.login(this.username,this.password);
    alert("hien thi" + resp);
    resp.subscribe(data=>{
      this.message = data;
      this.router.navigate(["/home"])
    })
  }

}
