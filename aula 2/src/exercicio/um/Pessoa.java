package exercicio.um;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public abstract class Pessoa {

    private String nome;
    private LocalDate dataNascimento;
    private Genero genero;


    public Pessoa(String nome, LocalDate dataNascimento, Genero genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }


    public void imprimirInformacoes(){
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + Period.between(this.dataNascimento,LocalDate.now()).getYears());
        System.out.println("Gênero: " + getGenero());
    }

    public String getNome() {
        return nome;
    }

    public Genero getGenero() {
        return genero;
    }


}
