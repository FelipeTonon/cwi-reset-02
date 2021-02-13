package exercicio.um;

public class Filme {

    private String nomeDoFilme;
    private String descricao;
    private double duracao;
    private int anoDeLancamento;
    private double avaliacao;


    public Filme(String nomeDoFilme, String descricao, double duracao) {
        this.nomeDoFilme = nomeDoFilme;
        this.descricao = descricao;
        this.duracao = duracao;
    }

    public String getNomeDoFilme() {
        return nomeDoFilme;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getDuracao() {
        return duracao;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }
}

