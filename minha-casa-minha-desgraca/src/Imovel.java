public abstract class Imovel {

    private TipoDoImovel tipo;
    private Double valor;
    private Endereco endereco;
    private String cidade;
    private UnidadeFederativa estado;
    private String logradouro;
    private Integer numero;
    private String bairro;
    private String complemento;

    public Imovel(TipoDoImovel tipo, Double valor, Endereco endereco) {
        this.tipo = tipo;
        this.valor = valor;
        this.endereco = endereco;
        cidade = endereco.getCidade();
        estado = endereco.getEstado();
        logradouro = endereco.getLogradouro();
        numero = endereco.getNumero();
        bairro = endereco.getBairro();
        complemento = endereco.getComplemento();
    }

    public abstract String apresentacao();

    public TipoDoImovel getTipo() {
        return tipo;
    }

    public Double getValor() {
        return valor;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public UnidadeFederativa getEstado() {
        return estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getComplemento() {
        return complemento;
    }

}
