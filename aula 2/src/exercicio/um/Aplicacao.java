package exercicio.um;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {

        List<Pessoa> elencoBatman = new ArrayList<Pessoa>();

        LocalDate nascimentoSnyder = LocalDate.of(1960,6,22);
        LocalDate nascimentoBale = LocalDate.of(1971,10,14);
        LocalDate nascimentoHenry = LocalDate.of(1981,4,9);
        LocalDate nascimentoFelipe = LocalDate.of(1996,5,3);


        Diretor snyder = new Diretor("Zack Snyder",nascimentoSnyder,11,Genero.MASCULINO);
        Ator bale = new Ator("Christian Bale",nascimentoBale,4,Genero.MASCULINO);
        Ator henry = new Ator("Henry Cavill",nascimentoHenry,0,Genero.MASCULINO);
        Ator felipe = new Ator("Felipe Tonon",nascimentoFelipe,5,Genero.MASCULINO);

        elencoBatman.add(snyder);
        elencoBatman.add(bale);
        elencoBatman.add(henry);
        elencoBatman.add(felipe);

        Filme batman = new Filme("Batman vs Superman",
                "Pior filme!",151d,2016,3,elencoBatman);

        batman.exibir();
        batman.creditos();


    }
}
