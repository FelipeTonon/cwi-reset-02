package br.com.cwi.reset.exemploreset;

import org.springframework.web.bind.annotation.*;

@RestController
public class NomeController {

private static String nome = "Felipe Tonon";

@GetMapping("/nome")
    public String meuNome(){
        return this.nome;
    }

@PutMapping("/nome/{novoNome}")
    public String alterarNome(@PathVariable("novoNome") String novoNome){
    this.nome = novoNome;
    return this.nome;
}

@DeleteMapping("/nome")
    public String deletarNome(){
    return this.nome = null;
    }

}
