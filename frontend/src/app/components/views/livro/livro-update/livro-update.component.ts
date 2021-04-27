import {Component, OnInit} from '@angular/core';
import {Livro} from "../livro.model";
import {FormControl, Validators} from "@angular/forms";
import {LivroService} from "../livro.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
    selector: 'app-livro-update',
    templateUrl: './livro-update.component.html',
    styleUrls: ['./livro-update.component.css']
})
export class LivroUpdateComponent implements OnInit {

    id_cat: String = '';

    livro: Livro = {
        id: '',
        titulo: '',
        nomeAutor: '',
        texto: ''
    }

    titulo = new FormControl('', [Validators.minLength(3)]);
    nomeAutor = new FormControl('', [Validators.minLength(3)]);
    texto = new FormControl('', [Validators.minLength(10)]);

    constructor(private service: LivroService, private route: ActivatedRoute, private router: Router) {
    }

    ngOnInit(): void {
        this.id_cat = this.route.snapshot.paramMap.get('id_cat')!;
        this.livro.id = this.route.snapshot.paramMap.get('id')!;
        this.findByI();

    }


    cancelar(): void {
        this.router.navigate([`categorias/${this.id_cat}/livros`]);
    }


    findByI(): void {
        this.service.findById(this.livro.id!).subscribe((resposta) => {
            this.livro = resposta;
        });
    }

    update(): void {
        this.service.update(this.livro).subscribe((resposta) => {
            this.router.navigate([`categorias/${this.id_cat}/livros`]);
            this.service.mensagem('Livro atualizado com sucesso!');
        }, err => {
            this.router.navigate([`categorias/${this.id_cat}/livros`]);
            this.service.mensagem('Falha ao atualizar livro! Tente Novamente..');
        });
    }


    chamarMensagens() {

        if ((this.titulo.invalid && this.nomeAutor.invalid && this.texto.invalid)) {


            return true;
        }
        return false;

    }

    getmessage() {
        if (this.titulo.invalid) {

            return 'O campo TITULO deve conter entre 3 e 100 caracteres'

        }
        if (this.nomeAutor.invalid) {

            return 'O campo NOME DO AUTOR deve conter entre 3 e 100 caracteres'

        }

        if (this.texto.invalid) {

            return 'O campo TEXTO deve conter entre 10 e 2.000.000 caracteres'

        }


        return false;
    }

    getmessageAutor() {

        if (this.nomeAutor.invalid) {

            return 'O campo NOME DO AUTOR deve conter entre 3 e 100 caracteres'

        }
        return false;

    }

    getmessageTexto() {

        if (this.texto.invalid) {

            return 'O campo TEXTO deve conter entre 10 e 2.000.000 caracteres'

        }

        return false;

    }

}
