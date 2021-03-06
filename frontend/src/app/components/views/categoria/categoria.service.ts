import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Categoria} from "./categoria.model";

import {MatSnackBar} from "@angular/material/snack-bar";
import {environment} from "../../../../environments/environment.prod";

@Injectable({
    providedIn: 'root'
})
export class CategoriaService {

    baseUrl: String = environment.baseUrl;

    constructor(private http: HttpClient,private _snack: MatSnackBar) {
    }

    //Metodo para listar todas as categorias
    findAll(): Observable<Categoria[]> {
        const url = `${this.baseUrl}/categorias`
        return this.http.get<Categoria[]>(url)

    }

    //Busca uma categoria por id
    findById(id: String):Observable<Categoria>{

        const url = `${this.baseUrl}/categorias/${id}`
        return this.http.get<Categoria>(url);

    }

    //Metodo para inserir uma categoria
    create(categoria:Categoria):Observable<Categoria>{

        const url = `${this.baseUrl}/categorias`
        return this.http.post<Categoria>(url,categoria);

    }

    //Metodo para deletar uma categoria
    delete(id: String):Observable<void>{

        const url = `${this.baseUrl}/categorias/${id}`
        return this.http.delete<void>(url);
        
    }

   //MEtodo para atualizar uma categoria
    update(categoria: Categoria):Observable<void>{

        const url = `${this.baseUrl}/categorias/${categoria.id}`
        return this.http.put<void>(url,categoria)

    }
    
    //Metodo para exibir uma mensagem na tela
    mensagem(str: String):void{
     this._snack.open(`${str}`,'OK',{
        horizontalPosition:'end',
         verticalPosition:'top',
         duration:3000
     });

    }




}
