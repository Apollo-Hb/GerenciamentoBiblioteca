package br.edu.unisep.biblioteca.util;

import br.edu.unisep.biblioteca.model.*;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Funcao {
    private List<Livro> livros;
    private List<Autor> autores;
    private List<Genero> generos;
    private List<Emprestimo> emprestimos;
    private List<Usuario> usuarios;

    public Funcao() {
        livros = new ArrayList<>();
        autores = new ArrayList<>();
        generos = new ArrayList<>();
        emprestimos = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void cadastrarAutor(Autor autor) {
        autores.add(autor);
        System.out.println("Autor cadastrado com sucesso: " + autor);
    }

    public void cadastrarGenero(Genero genero) {
        generos.add(genero);
        System.out.println("Gênero cadastrado com sucesso: " + genero);
    }

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro cadastrado com sucesso: " + livro);
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso: " + usuario);
    }

    public void emprestarLivro(Livro livro, Usuario usuario) {
        Emprestimo emprestimo = new Emprestimo(emprestimos.size() + 1, livro, usuario, LocalDate.now(), null);
        emprestimos.add(emprestimo);
        System.out.println("Empréstimo realizado com sucesso: " + emprestimo);
    }

    public void devolverLivro(int emprestimoId) {
        Emprestimo emprestimo = emprestimos.stream().filter(e -> e.getId() == emprestimoId).findFirst().orElse(null);
        if (emprestimo != null && emprestimo.getDataDevolucao() == null) {
            emprestimo.setDataDevolucao(LocalDate.now());
            System.out.println("Livro devolvido com sucesso: " + emprestimo);
        } else {
            System.out.println("Empréstimo não encontrado ou livro já devolvido.");
        }
    }

    public void consultarLivrosDisponiveis() {
        System.out.println("Livros disponíveis:");
        for (Livro livro : livros) {
            boolean estaEmprestado = false;
            for (Emprestimo emprestimo : emprestimos) {
                if (emprestimo.getLivro().equals(livro) && emprestimo.getDataDevolucao() == null) {
                    estaEmprestado = true;
                    break;
                }
            }
            if (!estaEmprestado) {
                System.out.println(livro);
            }
        }
    }

    public void salvarDados() {
    }
}
