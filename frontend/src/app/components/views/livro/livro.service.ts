import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Livro} from "./livro.model";
import {environment} from "../../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class LivroService {

   baseUrl: String = environment.baseUrl

  constructor() { }

  findAllByCategoria(id_cat:String):Observable<Livro[]>{

     const url = `${this.baseUrl}/livros?categoria=${id_cat}`


  }

}
