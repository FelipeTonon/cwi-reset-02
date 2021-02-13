package exercicio.um;

public class Diretor {

    private String nomeCompleto;
    private int idadeDoDiretor;
    private int quantidadeDeFilmesDirigidos;

    public Diretor(String nomeCompleto, int idadeDoDiretor, int quantidadeDeFilmesDirigidos) {
        this.nomeCompleto = nomeCompleto;
        this.idadeDoDiretor = idadeDoDiretor;
        this.quantidadeDeFilmesDirigidos = quantidadeDeFilmesDirigidos;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public int getIdadeDoDiretor() {
        return idadeDoDiretor;
    }

    public int getQuantidadeDeFilmesDirigidos() {
        return quantidadeDeFilmesDirigidos;
    }
}
