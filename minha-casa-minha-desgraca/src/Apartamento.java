public class Apartamento extends Imovel{

    private Integer andar;

    public Apartamento(TipoDoImovel tipo, Double valor, Endereco endereco, Integer andar) {
        super(tipo, valor, endereco);
        this.andar = andar;
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

    public Integer getAndar() {
        return andar;
    }

}
