package com.db.biblioteca.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.biblioteca.mappers.BibliotecaMapper;
import com.db.biblioteca.mappers.LivroMapper;
import com.db.biblioteca.model.Biblioteca;
import com.db.biblioteca.model.Livro;
import com.db.biblioteca.model.dto.BibliotecaRespostaDto;
import com.db.biblioteca.model.dto.CriarBibliotecaDto;
import com.db.biblioteca.model.dto.CriarLivroDto;
import com.db.biblioteca.services.BibliotecaService;

import java.util.List;

@RestController
@RequestMapping(value = "/bibliotecas")
public class BibliotecaController {

    private BibliotecaMapper bibliotecaMapper;
    private BibliotecaService bibliotecaService;
    private LivroMapper livroMapper;

    public BibliotecaController(BibliotecaMapper bibliotecaMapper, BibliotecaService bibliotecaService,
            LivroMapper livroMapper) {
        this.bibliotecaMapper = bibliotecaMapper;
        this.bibliotecaService = bibliotecaService;
        this.livroMapper = livroMapper;
    }

    @PostMapping
    public BibliotecaRespostaDto criarBiblioteca(@RequestBody CriarBibliotecaDto dto) {
        Biblioteca biblioteca = bibliotecaMapper.toBiblioteca(dto);
        this.bibliotecaService.criarBiblioteca(biblioteca);
        return bibliotecaMapper.toBibliotecaRespostaDto(biblioteca);
    }

    @PatchMapping("/{id}/livro")
    public ResponseEntity<String> adicionarLivro(@RequestBody CriarLivroDto dto, @PathVariable("id") Long id) {
        Livro livro = livroMapper.toLivro(dto);
        this.bibliotecaService.adicionarLivroNaBiblioteca(id, livro);
        return ResponseEntity.ok().body("Livro adicionado com sucesso!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<BibliotecaRespostaDto> listarBibliotecaPorId(@PathVariable("id") Long id) {
        Biblioteca biblioteca = this.bibliotecaService.buscarBibliotecaPorId(id);
        BibliotecaRespostaDto resposta = bibliotecaMapper.toBibliotecaRespostaDto(biblioteca);
        return ResponseEntity.ok().body(resposta);
    }

    @GetMapping
    public ResponseEntity<List<BibliotecaRespostaDto>> listarTodasAsBibliotecas() {
        List<Biblioteca> bibliotecas = this.bibliotecaService.buscarTodasBibliotecas();
        List<BibliotecaRespostaDto> resposta = bibliotecaMapper.toListToBibliotecaRespostaDto(bibliotecas);
        return ResponseEntity.ok().body(resposta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarBiblioteca(@PathVariable("id") Long id) {
        this.bibliotecaService.removerBibliotecaPorId(id);
        return ResponseEntity.ok().body("Biblioteca deletada com sucesso!");
    }

    @DeleteMapping("/{bibliotecaId}/livro/{livroId}")
    public ResponseEntity<String> deletarLivroDaBiblioteca(@PathVariable("bibliotecaId") Long bibliotecaId,
            @PathVariable("livroId") Long livroId) {
        this.bibliotecaService.removerLivroDaBiblioteca(bibliotecaId, livroId);
        return ResponseEntity.ok().body("Livro deletado com sucesso!");

    }

}
