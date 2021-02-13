package exercicio.um;

public class Aplicacao {

    public static void main(String[] args) {

        Ator bale = new Ator("Christian Bale",47,4,Genero.MASCULINO);
        Ator cameron = new Ator("Cameron Diaz",48,0,Genero.FEMININO);


        Diretor snyder = new Diretor("Zack Snyder",54,11,Genero.MASCULINO);
        Diretor miller = new Diretor("George Miller",75,16,Genero.NAO_BINARIO);


        Filme batman = new Filme("Batman vs Superman",
                "Pior filme!",151,2016,3,snyder);

        Filme madMax = new  Filme("MadMax","Sobrevivendo nas estradas da morte.",
                88,1979,7,miller);

        batman.exibir();
        madMax.exibir();

        snyder.imprimirInformacoes();
        miller.imprimirInformacoes();

        cameron.imprimirInformacoes();
        bale.imprimirInformacoes();

    }
}
