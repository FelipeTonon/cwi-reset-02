public class Apartamento extends Imovel{

    private Integer andar;

    public Apartamento(TipoDoImovel tipo, Double valor, Endereco endereco, Integer andar) {
        super(tipo, valor, endereco);
        this.andar = andar;
    }

    @Override
    public String apresentacao(){

        System.out.println("*** INFORMAÇÕES DO IMÓVEL *** ");
        System.out.println("Cidade: " + getCidade());
        System.out.println("Estado: " + getEstado());
        System.out.println("Logradouro: " + getLogradouro());
        System.out.println("Número: " + getNumero());
        System.out.println("Bairro: " + getBairro());
        System.out.println("Complemento: " + getComplemento());
        System.out.println("Tipo do imóvel: " + getTipo());
        System.out.println("Andar: " + this.andar);
        System.out.println("*** PREÇO DESSA BARBADINHA ***");
        System.out.println("Valor: R$ " + this.getValor());
        return null;

    }

}
