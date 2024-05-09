package com.db.biblioteca.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.biblioteca.mappers.LivroMapper;
import com.db.biblioteca.model.Livro;
import com.db.biblioteca.model.dto.LivroRespostaDto;
import com.db.biblioteca.services.LivroService;

import java.util.List;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {
    private LivroService livroService;
    private LivroMapper livroMapper;

    public LivroController(LivroService livroService, LivroMapper livroMapper) {
        this.livroService = livroService;
        this.livroMapper = livroMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroRespostaDto> buscarLivroPorId(@PathVariable("id") Long id) {
        Livro livro = this.livroService.buscarLivroPorId(id);
        LivroRespostaDto resposta = livroMapper.toLivroRespostaDto(livro);
        return ResponseEntity.ok().body(resposta);
    }

    @GetMapping("/titulo-biblioteca")
    public ResponseEntity<List<LivroRespostaDto>> buscarLivrosPorTituloEBibliotecaId(
            @RequestParam(required = true) String titulo,
            @RequestParam(required = true) Long bibliotecaId) {
        List<Livro> livros = this.livroService.buscarLivrosPorTituloEBibliotecaId(titulo, bibliotecaId);
        List<LivroRespostaDto> resposta = livroMapper.toListaDeLivroToRespostaDto(livros);
        return ResponseEntity.ok().body(resposta);
    }

    @GetMapping("/autor-biblioteca")
    public ResponseEntity<List<LivroRespostaDto>> buscarLivrosPorAutorEBibliotecaId(
            @RequestParam(required = true) String autor,
            @RequestParam(required = true) Long bibliotecaId) {
        List<Livro> livros = this.livroService.buscarLivrosPorAutorEBibliotecaId(autor, bibliotecaId);
        List<LivroRespostaDto> resposta = livroMapper.toListaDeLivroToRespostaDto(livros);
        return ResponseEntity.ok().body(resposta);
    }

    @GetMapping("/anoDePublicacao-biblioteca")
    public ResponseEntity<List<LivroRespostaDto>> buscarLivrosPorAnoPublicacaoEBibliotecaId(
            @RequestParam(required = true) Integer anoDePublicacao,
            @RequestParam(required = true) Long bibliotecaId) {
        List<Livro> livros = this.livroService.buscarLivrosPorAnoPublicacaoEBibliotecaId(anoDePublicacao, bibliotecaId);
        List<LivroRespostaDto> resposta = livroMapper.toListaDeLivroToRespostaDto(livros);
        return ResponseEntity.ok().body(resposta);
    }

    @GetMapping("/biblioteca/{id}")
    public ResponseEntity<List<LivroRespostaDto>> buscarLivroPorBibliotecaId(@PathVariable("id") Long id) {
        List<Livro> livros = this.livroService.buscarTodosLivrosPorBibliotecaId(id);
        List<LivroRespostaDto> resposta = livroMapper.toListaDeLivroToRespostaDto(livros);
        return ResponseEntity.ok().body(resposta);
    }

    @GetMapping("/titulo")
    public ResponseEntity<List<LivroRespostaDto>> buscarLivroPorTitulo(@RequestParam(required = true) String titulo) {
        List<Livro> livros = this.livroService.buscarLivrosPorTitulo(titulo);
        List<LivroRespostaDto> resposta = livroMapper.toListaDeLivroToRespostaDto(livros);
        return ResponseEntity.ok().body(resposta);
    }

    @GetMapping("/autor")
    public ResponseEntity<List<LivroRespostaDto>> buscarLivroPorAutor(@RequestParam(required = true) String autor) {
        List<Livro> livros = this.livroService.buscarLivrosPorAutor(autor);
        List<LivroRespostaDto> resposta = livroMapper.toListaDeLivroToRespostaDto(livros);
        return ResponseEntity.ok().body(resposta);
    }

    @GetMapping("/anoDePublicacao")
    public ResponseEntity<List<LivroRespostaDto>> buscarLivroPorAnoPublicacao(
            @RequestParam(required = true) Integer anoPublicacao) {
        List<Livro> livros = this.livroService.buscarLivrosPorAnoDePublicacao(anoPublicacao);
        List<LivroRespostaDto> resposta = livroMapper.toListaDeLivroToRespostaDto(livros);
        return ResponseEntity.ok().body(resposta);
    }

}
