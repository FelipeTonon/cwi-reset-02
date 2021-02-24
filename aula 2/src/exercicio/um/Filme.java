package exercicio.um;

import java.util.ArrayList;
import java.util.List;

public class Filme {

    private String nomeDoFilme;
    private String descricao;
    private Double duracao;
    private Integer anoDeLancamento;
    private Integer avaliacao;
    private List<Pessoa> elenco;


    public Filme(String nomeDoFilme, String descricao, Double duracao, Integer anoDeLancamento, Integer avaliacao, List<Pessoa> elenco) {
        defineAvaliacao(avaliacao);
        defineAvaliacaoPeloNome(nomeDoFilme);
        this.nomeDoFilme = nomeDoFilme;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoDeLancamento = anoDeLancamento;
        this.elenco = elenco;
    }

    private void defineAvaliacao(Integer avaliacao){
        if(avaliacao < 1 || avaliacao > 5){
            this.avaliacao = 3;
        } else {
            this.avaliacao = avaliacao;
        }
    }

    private void defineAvaliacaoPeloNome(String nomeDoFilme){
        if("Batman vs Superman".equals(nomeDoFilme)){
            this.avaliacao = 1;
        } else if("Clube da Luta".equals(nomeDoFilme)) {
            this.avaliacao = 5;
        } else {
            this.avaliacao = avaliacao;
        }
    }

    public void exibir() {
        System.out.println("Nome do filme: " + this.nomeDoFilme);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Duração: " + this.duracao + " minutos");
        System.out.println("Ano de lançamento: " + this.anoDeLancamento);
        System.out.println("Avaliação: " + this.avaliacao);
        System.out.println("");
    }

    public void creditos(){
        System.out.println("***  CRÉDITOS  ***");
        System.out.println("ELENCO:");

        for (Pessoa pessoa: elenco){
            pessoa.imprimirInformacoes();
        }
    }

}


