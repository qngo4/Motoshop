import { Component, OnInit } from '@angular/core';
import { RestapiService } from '../restapi.service';
import { Router } from '@angular/router';
import { HttpHeaders, HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username : String;
  password : String;
  message : any
  constructor(private service: RestapiService, private router: Router,
    private http: HttpClient) { }

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

  signInAccount() {
    const body = JSON.stringify({    "userId": 0,    "password": "password",	"role": 1,    "userName": "userName"});
        return this.http
            .post(`http://localhost:8080/Motoshop/login/userName` + `/${this.username}`, body, { headers: new HttpHeaders() })
            .pipe( );
  }

}
