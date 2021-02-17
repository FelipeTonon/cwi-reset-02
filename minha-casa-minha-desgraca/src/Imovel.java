public abstract class Imovel {

    private TipoDoImovel tipo;
    private Double valor;
    private Endereco endereco;
    private UnidadeFederativa estado;


    public Imovel(TipoDoImovel tipo, Double valor, Endereco endereco) {
        this.tipo = tipo;
        this.valor = valor;
        this.endereco = endereco;
        estado = endereco.getEstado();
    }

    public String apresentacao(){

        System.out.println("*** PREÇO DESSA BARBADINHA ***");
        System.out.println("Valor: R$ " + this.valor);
        System.out.println("*** INFORMAÇÕES DO IMÓVEL *** ");
        System.out.println("Cidade: " + endereco.getCidade());
        System.out.println("Estado: " + endereco.getEstado());
        System.out.println("Tipo do imóvel: " + this.tipo);
        System.out.println("Logradouro: " + endereco.getLogradouro());
        System.out.println("Número: " + endereco.getNumero());
        System.out.println("Bairro: " + endereco.getBairro());
        System.out.println("Complemento: " + endereco.getComplemento());

        return null;
    }


    public Double getValor() {
        return valor;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public UnidadeFederativa getEstado() {
        return estado;
    }
}
