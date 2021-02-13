package exercicio.um;

public class Diretor extends Pessoa {

    private Integer quantidadeDeFilmesDirigidos;

    public Diretor(String nome, Integer idade, Integer quantidadeDeFilmesDirigidos, Genero genero) {
        super(nome, idade, genero);
        this.quantidadeDeFilmesDirigidos = quantidadeDeFilmesDirigidos;
    }

    @Override
    public void imprimirInformacoes(){
        super.imprimirInformacoes();
        System.out.println("Quantidade de filmes dirigidos: " + this.quantidadeDeFilmesDirigidos);
        System.out.println("");
    }

}