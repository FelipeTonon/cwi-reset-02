package com.company;

import com.company.domain.Editora;
import com.company.domain.Filme;
import com.company.enumerador.Genero;
import com.company.herança.Diretor;

public class AplicacaoTeste {

    public static void main(String[] args) {

        Diretor diretor = new Diretor("Brutus",35,15, Genero.MASCULINO);
        Filme batman = new Filme("Batman","Morcegão",80,2008,6,diretor);
        batman.reproduzir();

        Editora editora = new Editora("DC Comics","EUA");
        editora.exibir();

    }
}
