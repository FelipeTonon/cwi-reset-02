package exercicio.um;

import java.time.LocalDate;

public class Diretor extends Pessoa {

    private Integer quantidadeDeFilmesDirigidos;

    public Diretor(String nome, LocalDate dataNascimento, Integer quantidadeDeFilmesDirigidos, Genero genero) {
        super(nome, dataNascimento, genero);
        this.quantidadeDeFilmesDirigidos = quantidadeDeFilmesDirigidos;
    }

    @Override
    public void imprimirInformacoes(){
        super.imprimirInformacoes();
        System.out.println("Quantidade de filmes dirigidos: " + this.quantidadeDeFilmesDirigidos);
        System.out.println("");
    }

}