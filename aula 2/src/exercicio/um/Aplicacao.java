package exercicio.um;

public class Aplicacao {

    public static void main(String[] args) {

        Filme batman = new Filme("Batman - O Cavaleiro das Trevas","Proteger Gotham das armações do Coringa.",152);
        Filme madMax = new Filme("Mad Max","Sobreviver nas estradas da morte.",88);

        Diretor nolan = new Diretor("Christopher Nolan",50,12);
        Diretor miller = new Diretor("George Miller",75,12);

        System.out.println("Nome do filme: " + batman.getNomeDoFilme());
        System.out.println("Descrição: " + batman.getDescricao());
        System.out.println("Duração: " + batman.getDuracao() + " minutos");
        System.out.println("Diretor: " + nolan.getNomeCompleto());
        System.out.println("");

        System.out.println("Nome do filme: " + madMax.getNomeDoFilme());
        System.out.println("Descrição: " + madMax.getDescricao());
        System.out.println("Duração: " + madMax.getDuracao() + " minutos");
        System.out.println("Diretor: " + miller.getNomeCompleto());
        System.out.println("");
    }
}
