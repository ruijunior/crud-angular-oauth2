import { Funcionario } from './funcionario';
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class FuncionarioService {

  private url = 'api/funcionarios/funcionarios.json';

  constructor(private http: HttpClient) { }

  getFuncionarios() : Observable<Funcionario[]> {
    return this.http.get<Funcionario[]>(this.url).pipe(
      tap(data => console.log('All: ' + JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  private handleError(err: HttpErrorResponse): Observable<never> {
    let errorMessage = '';
    if (err.error instanceof ErrorEvent) {
      errorMessage = `Ocorreu um erro: ${err.error.message}`;
    } else {
      errorMessage = `Código de erro retornado pelo servidor: ${err.status}, Mensagem de erro: ${err.message}`;
    }
    console.error(errorMessage);
    return throwError(errorMessage);
  }
}
