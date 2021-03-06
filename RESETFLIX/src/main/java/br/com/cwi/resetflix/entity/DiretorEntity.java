package br.com.cwi.resetflix.entity;

import java.util.List;

public class DiretorEntity {

    private Long id;
    private String nome;
    private List<Long> idsFilme;

    public DiretorEntity(String nome, List<Long> idsFilme) {
        this.nome = nome;
        this.idsFilme = idsFilme;
    }

    public DiretorEntity(Long id, String nome, List<Long> idsFilme) {
        this.id = id;
        this.nome = nome;
        this.idsFilme = idsFilme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Long> getIdsFilme() {
        return idsFilme;
    }

    public void setIdsFilme(List<Long> idsFilme) {
        this.idsFilme = idsFilme;
    }
}
