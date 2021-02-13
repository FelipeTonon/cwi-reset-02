package exercicio.um;

public class Filme {

    private String nomeDoFilme;
    private String descricao;
    private double duracao;
    private Integer anoDeLancamento;
    private Integer avaliacao;
    private Diretor diretor;

    public Filme(String nomeDoFilme, String descricao, double duracao, Integer anoDeLancamento, Integer avaliacao,
                 Diretor diretor) {
        defineAvaliacao(avaliacao);
        defineAvaliacaoPeloNome(nomeDoFilme);
        this.nomeDoFilme = nomeDoFilme;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoDeLancamento = anoDeLancamento;
        this.diretor = diretor;
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
        System.out.println("Diretor: " + diretor.getNome());
        System.out.println("");
    }

}


