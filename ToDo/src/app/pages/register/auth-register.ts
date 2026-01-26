import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthRegister {

  private url = 'http://localhost:9999';

  constructor(private http: HttpClient) { }

  login(usuario: any): Observable<any> {
    return this.http.post(`${this.url}/login`, usuario);
  }
  
}
