package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.mapper.FilmeEntityMapper;
import br.com.cwi.resetflix.mapper.FilmeResponseMapper;
import br.com.cwi.resetflix.repository.FilmeRepository;
import br.com.cwi.resetflix.request.CriarFilmeRequest;
import br.com.cwi.resetflix.response.FilmeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmesService {

    @Autowired
    FilmeRepository filmeRepository;

    static FilmeEntityMapper ENTITY_MAPPER = new FilmeEntityMapper();
    static FilmeResponseMapper RESPONSE_MAPPER = new FilmeResponseMapper();

    public Long criarFilme(CriarFilmeRequest request) {
        FilmeEntity filmeSalvar = ENTITY_MAPPER.mapear(request);
        return filmeRepository.criarFilme(filmeSalvar);
    }

    public List<FilmeResponse> getFilme() {
        List<FilmeEntity> filmeExibir = filmeRepository.getFilmes();
        return RESPONSE_MAPPER.mapear(filmeExibir);

    }
}
