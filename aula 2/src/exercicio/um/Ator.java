package exercicio.um;

import java.time.LocalDate;

public class Ator extends Pessoa {

    private Integer oscars;

    public Ator(String nome, LocalDate dataNascimento, Integer oscars, Genero genero) {
        super(nome, dataNascimento, genero);
        this.oscars = oscars;
    }

    @Override
    public void imprimirInformacoes(){
        super.imprimirInformacoes();
        System.out.println("Oscar ganhos: " + this.oscars);
        System.out.println("");
    }

}
