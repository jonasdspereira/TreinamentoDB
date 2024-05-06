package com.db.biblioteca.services.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.db.biblioteca.model.Livro;
import com.db.biblioteca.repositories.LivroRepository;
import com.db.biblioteca.services.LivroService;

@Service
public class LivroServiceImpl implements LivroService {

    private LivroRepository livroRepository;

    public LivroServiceImpl(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Override
    public Livro buscarLivroPorId(Long id) {
        return livroRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Livro não encontrado"));
    }

    @Override
    public List<Livro> buscarLivrosPorTituloEBibliotecaId(String titulo, Long bibliotecaId) {
        return livroRepository.findAllByTituloAndBibliotecaId(titulo, bibliotecaId);
    }

    @Override
    public List<Livro> buscarLivrosPorAutorEBibliotecaId(String autor, Long bibliotecaId) {
        return livroRepository.findAllByAutorAndBibliotecaId(autor, bibliotecaId);
    }

    @Override
    public List<Livro> buscarLivrosPorAnoPublicacaoEBibliotecaId(Integer anoPublicacao, Long bibliotecaId) {
        return livroRepository.findAllByAnoDePublicacaoAndBibliotecaId(anoPublicacao, bibliotecaId);
    }

    @Override
    public List<Livro> buscarTodosLivrosPorBibliotecaId(Long bibliotecaId) {
        return livroRepository.findAllByBibliotecaId(bibliotecaId);
    }

    @Override
    public List<Livro> buscarLivrosPorTitulo(String titulo) {
        return livroRepository.findAllByTitulo(titulo);
    }

    @Override
    public List<Livro> buscarLivrosPorAutor(String autor) {
        return livroRepository.findAllByAutor(autor);
    }

    @Override
    public List<Livro> buscarLivrosPorAnoDePublicacao(Integer anoPublicacao) {
        return livroRepository.findAllByAnoDePublicacao(anoPublicacao);
    }

}
