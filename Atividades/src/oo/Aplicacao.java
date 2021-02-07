package oo;

public class Aplicacao {

    public static void main(String[] args) {

//      Exercício 1

        System.out.println("Exercício 1:");

        Calculadora hp = new Calculadora();

        int resultadoSoma = hp.soma(2,2);
        System.out.println("O resultado da soma é " + resultadoSoma);

        int resultadoSubtracao = hp.subtrai(5,3);
        System.out.println("O resultado da subtração é " + resultadoSubtracao);

        int resultadoMultiplicacao = hp.multiplica(3,3);
        System.out.println("O resultado da multiplicação é " + resultadoMultiplicacao);

        int resultadoDivisao = hp.divide(9,3);
        System.out.println("O resultado da divisão é " + resultadoDivisao);



//        Exercício 2

        System.out.println("");
        System.out.println("Exercício 2:");

        Comparador isMenor = new Comparador();

//      Primeiro parâmetro sendo menor

        boolean resultadoComparacao1 = isMenor.menorQue(1,2);
        System.out.println("O resultado da comparação do primeiro parâmetro ser menor é " + resultadoComparacao1);

//      Primeiro parâmetro sendo maior

        boolean resultadoComparacao2 = isMenor.menorQue(3,1);
        System.out.println("O resultado da comparação do primeiro parâmetro ser menor é " + resultadoComparacao2);



//      Exercício 3

        System.out.println("");
        System.out.println("Exercício 3:");

//      Aluno Aprovado

        Alunos AlunoFulano = new Alunos("Felipe",8);

        AlunoFulano.isAprovado();

//      Aluno Reprovado

        Alunos AlunoCiclano = new Alunos("Peter",6);

        AlunoCiclano.isAprovado();

    }

}
