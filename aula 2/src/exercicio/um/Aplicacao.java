package exercicio.um;

public class Aplicacao {

    public static void main(String[] args) {

        Diretor nolan = new Diretor("Christopher Nolan",50,24);
        Diretor miller = new Diretor("George Miller",75,18);

        Filme batman = new Filme("Batman - O Cavaleiro das Trevas",
                "Protegendo Gotham das armações do Coringa.",152,2008,4.5,nolan);

        Filme madMax = new  Filme("Mad Max","Sobrevivendo nas estradas da morte.",
                88,1979,4.3,miller);

        batman.exibir();
        madMax.exibir();
    }
}
