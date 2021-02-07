package oo;

public class Alunos {

    private String nomeDoAluno;

    private int notaFinal;

    private boolean resultadoAluno;


    public Alunos(String nomeDoAluno, int notaFinal) {

        this.nomeDoAluno = nomeDoAluno;
        this.notaFinal = notaFinal;

        System.out.println("O aluno " + nomeDoAluno + " com nota final de " + notaFinal + " foi instanciado.");
    }


   void isAprovado() {

        resultadoAluno = false;

        if (this.notaFinal >= 7) {
            resultadoAluno = true;
        }

        System.out.println("O aluno foi aprovado? " + resultadoAluno);

    }

}