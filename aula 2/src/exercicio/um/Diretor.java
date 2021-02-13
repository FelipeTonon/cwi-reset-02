package exercicio.um;

public class Diretor {

    private String nomeCompleto;
    private Integer idadeDoDiretor;
    private Integer quantidadeDeFilmesDirigidos;

    public Diretor(String nomeCompleto, Integer idadeDoDiretor, Integer quantidadeDeFilmesDirigidos) {
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
