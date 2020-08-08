import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RestapiService {

  constructor(private  http:HttpClient) { }

  login(username : String , password: String){
    alert("api check "+username + password);
    let body = JSON.parse(JSON.stringify(username));
    let body1 = JSON.parse(JSON.stringify(password));
    let body2= body + body1;
    const headers = new HttpHeaders({Authorization: 'Basic ' });
    alert(headers);
    return this.http.post("https://localhost:8080/Motoshop/login/"+body2,{headers}) 
  }

  signInAccount(username : String) {
    const body = JSON.stringify({    "userId": 0,    "password": "password",	"role": 1,    "userName": "qgno41"});
        return  this.http
            .post('http://localhost:8080/Motoshop/login/userName/'+ username, body, { headers : new HttpHeaders({ 'Content-Type': 'application/json'})  });

  }





//   getUser(){
//     let username='qngo4'
//     let password='123'
//     const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
//    return  this.http.get("http://localhost:8080/getUsers",{headers});
//   }
}
