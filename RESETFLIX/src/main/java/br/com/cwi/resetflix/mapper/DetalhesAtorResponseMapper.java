package br.com.cwi.resetflix.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.response.FilmeResponse;

public class DetalhesAtorResponseMapper {

    public List<FilmeResponse> mapear(final List<FilmeEntity> filmesAtor) {

        List<FilmeResponse> filmesResponse = new ArrayList<>();

        for(FilmeEntity filmeEntity : filmesAtor){

            filmesResponse.add(new FilmeResponse(filmeEntity.getId(), filmeEntity.getNome(), filmeEntity.getGenero()));

        }

        return filmesResponse;

    }
}
