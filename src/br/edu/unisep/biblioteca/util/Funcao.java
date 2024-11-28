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

    public Funcao() {
        livros = new ArrayList<>();
        autores = new ArrayList<>();
        generos = new ArrayList<>();
        emprestimos = new ArrayList<>();
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

    public void emprestarLivro(Livro livro, Usuario usuario) {
        Emprestimo emprestimo = new Emprestimo(emprestimos.size() + 1, livro, usuario, LocalDate.now(), null);
        emprestimos.add(emprestimo);
        System.out.println("Empréstimo realizado com sucesso: " + emprestimo);
    }

    public void devolverLivro(Emprestimo emprestimo) {
        emprestimo.setDataDevolucao(LocalDate.now());
        System.out.println("Livro devolvido com sucesso: " + emprestimo);
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

    // Novo método para salvar dados
    public void salvarDados() {
        boolean autoresSalvos = Funcao.salvarArquivosAutores(autores);
        boolean generosSalvos = Funcao.salvarArquivosGeneros(generos);
        boolean livrosSalvos = Funcao.salvarArquivosLivros(livros);

        if (autoresSalvos && generosSalvos && livrosSalvos) {
            System.out.println("Todos os dados foram salvos com sucesso.");
        } else {
            System.out.println("Erro ao salvar alguns dados.");
        }
    }

    private static boolean salvarArquivosLivros(List<Livro> livros) {
        return false;
    }

    private static boolean salvarArquivosGeneros(List<Genero> generos) {
        return false;
    }

    private static boolean salvarArquivosAutores(List<Autor> autores) {
        return false;
    }
}
