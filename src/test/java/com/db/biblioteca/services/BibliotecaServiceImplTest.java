package com.db.biblioteca.services;

import com.db.biblioteca.fixture.BibliotecaFixture;
import com.db.biblioteca.fixture.LivroFixture;
import com.db.biblioteca.model.Biblioteca;
import com.db.biblioteca.model.Livro;
import com.db.biblioteca.repositories.BibliotecaRepository;
import com.db.biblioteca.services.impl.BibliotecaServiceImpl;
import com.db.biblioteca.services.impl.LivroServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BibliotecaServiceImplTest {

    @InjectMocks
    private BibliotecaServiceImpl bibliotecaService;
    @Mock
    private BibliotecaRepository bibliotecaRepository;

    @Mock
    private LivroServiceImpl livroService;
    private Livro livro;

    private Biblioteca biblioteca;
    @BeforeEach
    void setup(){
        this.biblioteca = BibliotecaFixture.gerarBiblioteca();
        this.livro = LivroFixture.gerarLivro(biblioteca);
    }

    @Test
    @DisplayName("Deve se possivel adicionar um livro")
    void deveAdicionarLivroNaBibliotecaCorretamente(){
        when(this.bibliotecaRepository.findById(1L)).thenReturn(Optional.of(this.biblioteca));
        assertDoesNotThrow(()->this.bibliotecaService.adicionarLivroNaBiblioteca(1L,this.livro));
    }

    @Test
    @DisplayName("Deve falhar ao adicionar livro já adicionado")
    void deveFalharAoAdicionarLivroNaBiblioteca(){
        this.biblioteca.getLivros().add(livro);
        when(this.bibliotecaRepository.findById(1L)).thenReturn(Optional.of(this.biblioteca));
        assertThrows(IllegalArgumentException.class,()->this.bibliotecaService.adicionarLivroNaBiblioteca(1L,this.livro));
    }

    @Test
    @DisplayName("Deve buscar uma biblioteca por id")
    void deveBuscarBibliotecaPorId(){
        when(this.bibliotecaRepository.findById(1L)).thenReturn(Optional.of(this.biblioteca));
        assertDoesNotThrow(()-> this.bibliotecaService.buscarBibliotecaPorId(1L));
    }

    @Test
    @DisplayName("Deve falhar ao buscar uma biblioteca por id")
    void deveFalharAoUmaBuscarBibliotecaPorId(){
        assertThrows(NoSuchElementException.class,()->this.bibliotecaService.buscarBibliotecaPorId(1L));
    }

}
