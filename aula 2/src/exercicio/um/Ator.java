package exercicio.um;

public class Ator extends Pessoa {

    private Integer oscars;

    public Ator(String nome, Integer idade, Integer oscars, Genero genero) {
        super(nome, idade, genero);
        this.oscars = oscars;
    }

    @Override
    public void imprimirInformacoes(){
        super.imprimirInformacoes();
        System.out.println("Oscar ganhos: " + this.oscars);
        System.out.println("");
    }

}
