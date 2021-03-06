package br.com.cwi.resetflix.web;

import br.com.cwi.resetflix.request.CriarDiretorRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesDiretorResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;
import br.com.cwi.resetflix.service.DiretoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diretores")
public class DiretorController implements DiretoresContract{

    @Autowired
    DiretoresService diretoresService;

    @Override
    @GetMapping
    public List<DiretoresResponse> getDiretores() {
        return diretoresService.getDiretor();
    }

    @Override
    @GetMapping("/{id}")
    public ConsultarDetalhesDiretorResponse getDiretorById(@PathVariable("id") final Long id) {
        return diretoresService.consultarDetalhesAtor(id);
    }

    @Override
    @PostMapping
    public Long criarDiretor(@RequestBody CriarDiretorRequest request) {
        return diretoresService.criarDiretor(request);
    }
}
