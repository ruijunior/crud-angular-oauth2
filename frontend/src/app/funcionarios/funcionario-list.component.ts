import { FuncionarioService } from './funcionario.service';
import { Component, OnInit } from '@angular/core';
import { Funcionario } from './funcionario';

@Component({
  selector: 'app-funcionario-list',
  templateUrl: './funcionario-list.component.html',
  styleUrls: ['./funcionario-list.component.css']
})
export class FuncionarioListComponent implements OnInit {

  _listFilter : string;
  errorMessage: string;
  filteredFuncionarios: Funcionario[];

  funcionarios : Funcionario[];

  constructor(private funcionarioService: FuncionarioService) {
  }

  ngOnInit(): void {
    this.funcionarioService.getFuncionarios().subscribe({
      next: funcs => {
        this.funcionarios = funcs;
        this.filteredFuncionarios = this.funcionarios;
      },
      error: err => this.errorMessage = err
    });
  }

  get listFilter(): string {
    return this._listFilter;
  }

  set listFilter(value: string) {
    this._listFilter = value;
    this.filteredFuncionarios = this.listFilter ? this.performFilter(this.listFilter) : this.funcionarios;
  }

  performFilter(filterBy: string): Funcionario[] {
    filterBy = filterBy.toLocaleLowerCase();
    return this.funcionarios.filter((func: Funcionario) =>
      func.nome.toLocaleLowerCase().indexOf(filterBy) !== -1
    );
  }
}
