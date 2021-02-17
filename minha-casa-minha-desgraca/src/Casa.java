public class Casa extends Imovel{

    private Boolean patio;

    public Casa(TipoDoImovel tipo, Double valor, Endereco endereco, Boolean patio) {
        super(tipo, valor, endereco);
        this.patio = patio;
    }

    public Boolean getPatio() {
        return this.patio;
    }


}
