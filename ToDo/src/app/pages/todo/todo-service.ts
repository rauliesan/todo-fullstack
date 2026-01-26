import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class TodoService {
  
  url = 'http://localhost:9999';

  constructor(private http: HttpClient) { }

  //Pasar el id del cliente al componente todo
  

}
