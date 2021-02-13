package exercicio.um;

public class Filme {

    private String nomeDoFilme;
    private String descricao;
    private double duracao;
    private Integer anoDeLancamento;
    private Double avaliacao;
    private Diretor isDiretor;


    public Filme(String nomeDoFilme, String descricao, double duracao, Integer anoDeLancamento, Double avaliacao, Diretor isDiretor){
        this.nomeDoFilme = nomeDoFilme;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoDeLancamento = anoDeLancamento;
        this.avaliacao = avaliacao;
        this.isDiretor = isDiretor;
    }

    public void exibir(){
        System.out.println("Nome do filme: " + this.nomeDoFilme);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Duração: " + this.duracao + " minutos");
        System.out.println("Ano de lançamento: " + this.anoDeLancamento);
        System.out.println("Avaliação: " + this.avaliacao);
        System.out.println("Diretor: " + isDiretor.getNomeCompleto());
        System.out.println("");
    }

}


