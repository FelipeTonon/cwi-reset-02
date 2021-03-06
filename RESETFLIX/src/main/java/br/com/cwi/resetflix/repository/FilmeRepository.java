package br.com.cwi.resetflix.repository;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.FilmeEntity;

@Repository
public class FilmeRepository {

    static Long contadorIds = 1l;

    static List<FilmeEntity> filmes = new ArrayList<>();


    public List<FilmeEntity> getFilmes(){
        return filmes;
    }

    public List<FilmeEntity> acharFilmesAtor(final Long id) {

        List<FilmeEntity> filmesAtor = new ArrayList<>();

        for(FilmeEntity filmeEntity : filmes){

            if(filmeEntity.getIdsAtores().equals(id)){
                filmesAtor.add(filmeEntity);
                return filmesAtor;
            }

        }

    return null;

    }

    public Long criarFilme(FilmeEntity filmeSalvar) {
        if(filmeSalvar.getId() == null){
            filmeSalvar.setId(contadorIds);
            contadorIds++;
        }

        filmes.add(filmeSalvar);
        return filmeSalvar.getId();
    }
}
