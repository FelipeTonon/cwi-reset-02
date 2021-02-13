package exercicio.um;

public enum Genero {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    NAO_BINARIO("Não Binário");

    private String classificacao;

    Genero(String classificacao) {
        this.classificacao = classificacao;
    }

}
