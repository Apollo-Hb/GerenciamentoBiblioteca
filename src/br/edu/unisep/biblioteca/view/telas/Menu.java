package br.edu.unisep.biblioteca.view.telas;

import br.edu.unisep.biblioteca.model.*;
import br.edu.unisep.biblioteca.util.Funcao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class Menu {

    private Funcao funcao;

    public Menu() {
        funcao = new Funcao();
        exibir();
    }

    public void exibir() {
        JFrame janela = new JFrame("Menu Principal");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(600, 600);

        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        JButton JBtnAddLivro = new JButton("Adicionar Livro");
        JBtnAddLivro.setAlignmentX(Component.CENTER_ALIGNMENT);
        JBtnAddLivro.addActionListener(e -> new LivroAdd(funcao));
        painel.add(JBtnAddLivro);
        painel.add(Box.createRigidArea(new Dimension(0, 10))); // Adiciona um espaço

        JButton JBtnAddAutor = new JButton("Adicionar Autor");
        JBtnAddAutor.setAlignmentX(Component.CENTER_ALIGNMENT);
        JBtnAddAutor.addActionListener(e -> cadastrarAutor());
        painel.add(JBtnAddAutor);
        painel.add(Box.createRigidArea(new Dimension(0, 10))); // Adiciona um espaço

        JButton JBtnAddGenero = new JButton("Adicionar Gênero");
        JBtnAddGenero.setAlignmentX(Component.CENTER_ALIGNMENT);
        JBtnAddGenero.addActionListener(e -> cadastrarGenero());
        painel.add(JBtnAddGenero);
        painel.add(Box.createRigidArea(new Dimension(0, 10))); // Adiciona um espaço

        JButton JBtnListarAutores = new JButton("Listar Autores");
        JBtnListarAutores.setAlignmentX(Component.CENTER_ALIGNMENT);
        JBtnListarAutores.addActionListener(e -> listarAutores());
        painel.add(JBtnListarAutores);
        painel.add(Box.createRigidArea(new Dimension(0, 10))); // Adiciona um espaço

        JButton JBtnListarGeneros = new JButton("Listar Gêneros");
        JBtnListarGeneros.setAlignmentX(Component.CENTER_ALIGNMENT);
        JBtnListarGeneros.addActionListener(e -> listarGeneros());
        painel.add(JBtnListarGeneros);
        painel.add(Box.createRigidArea(new Dimension(0, 10))); // Adiciona um espaço

        JButton JBtnListarLivros = new JButton("Listar Livros");
        JBtnListarLivros.setAlignmentX(Component.CENTER_ALIGNMENT);
        JBtnListarLivros.addActionListener(e -> listarLivros());
        painel.add(JBtnListarLivros);
        painel.add(Box.createRigidArea(new Dimension(0, 10))); // Adiciona um espaço

        JButton JBtnListarLivrosDisponiveis = new JButton("Listar Livros Disponíveis");
        JBtnListarLivrosDisponiveis.setAlignmentX(Component.CENTER_ALIGNMENT);
        JBtnListarLivrosDisponiveis.addActionListener(e -> listarLivrosDisponiveis());
        painel.add(JBtnListarLivrosDisponiveis);
        painel.add(Box.createRigidArea(new Dimension(0, 10))); // Adiciona um espaço

        JButton JBtnEmprestarLivro = new JButton("Emprestar Livro");
        JBtnEmprestarLivro.setAlignmentX(Component.CENTER_ALIGNMENT);
        JBtnEmprestarLivro.addActionListener(e -> emprestarLivro());
        painel.add(JBtnEmprestarLivro);
        painel.add(Box.createRigidArea(new Dimension(0, 10))); // Adiciona um espaço

        JButton JBtnDevolverLivro = new JButton("Devolver Livro");
        JBtnDevolverLivro.setAlignmentX(Component.CENTER_ALIGNMENT);
        JBtnDevolverLivro.addActionListener(e -> devolverLivro());
        painel.add(JBtnDevolverLivro);
        painel.add(Box.createRigidArea(new Dimension(0, 10))); // Adiciona um espaço

        janela.add(painel);

        janela.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(janela,
                        "Dados salvos com sucesso!");
                System.exit(0);
            }
        });

        janela.setVisible(true);
    }

    private void cadastrarAutor() {
        String nome = JOptionPane.showInputDialog("Digite o nome do autor:");
        if (nome != null && !nome.trim().isEmpty()) {
            Autor autor = new Autor(funcao.getAutores().size() + 1, nome);
            funcao.cadastrarAutor(autor);
            JOptionPane.showMessageDialog(null, "Autor cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Nome do autor não pode ser vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cadastrarGenero() {
        String nome = JOptionPane.showInputDialog("Digite o nome do gênero:");
        if (nome != null && !nome.trim().isEmpty()) {
            Genero genero = new Genero(funcao.getGeneros().size() + 1, nome);
            funcao.cadastrarGenero(genero);
            JOptionPane.showMessageDialog(null, "Gênero cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Nome do gênero não pode ser vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listarAutores() {
        List<Autor> autores = funcao.getAutores();
        StringBuilder sb = new StringBuilder(String.format("%-10s %-30s%n", "ID", "Nome"));
        sb.append("------------------------------------------------\n");
        for (Autor autor : autores) {
            sb.append(String.format("%-10d %-30s%n", autor.getId(), autor.getNome()));
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Autores", JOptionPane.INFORMATION_MESSAGE);
    }

    private void listarGeneros() {
        List<Genero> generos = funcao.getGeneros();
        StringBuilder sb = new StringBuilder(String.format("%-10s %-30s%n", "ID", "Nome"));
        sb.append("------------------------------------------------\n");
        for (Genero genero : generos) {
            sb.append(String.format("%-10d %-30s%n", genero.getId(), genero.getNome()));
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Gêneros", JOptionPane.INFORMATION_MESSAGE);
    }

    private void listarLivros() {
        List<Livro> livros = funcao.getLivros();
        StringBuilder sb = new StringBuilder(String.format("%-10s %-30s %-20s %-20s%n", "ID", "Título", "Autor", "Gênero"));
        sb.append("------------------------------------------------\n");
        for (Livro livro : livros) {
            sb.append(String.format("%-10d %-30s %-20s %-20s%n",
                    livro.getId(), livro.getTitulo(), livro.getAutor().getNome(), livro.getGenero().getNome()));
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Livros", JOptionPane.INFORMATION_MESSAGE);
    }

    private void listarLivrosDisponiveis() {
        List<Livro> livros = funcao.getLivros();
        StringBuilder sb = new StringBuilder(String.format("%-10s %-30s %-20s %-20s%n", "ID", "Título", "Autor", "Gênero"));
        sb.append("------------------------------------------------\n");
        for (Livro livro : livros) {
            boolean estaEmprestado = false;
            for (Emprestimo emprestimo : funcao.getEmprestimos()) {
                if (emprestimo.getLivro().equals(livro) && emprestimo.getDataDevolucao() == null) {
                    estaEmprestado = true;
                    break;
                }
            }
            if (!estaEmprestado) {
                sb.append(String.format("%-10d %-30s %-20s %-20s%n",
                        livro.getId(), livro.getTitulo(), livro.getAutor().getNome(), livro.getGenero().getNome()));
            }
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Livros Disponíveis", JOptionPane.INFORMATION_MESSAGE);
    }

    private void emprestarLivro() {
        String livroIdStr = JOptionPane.showInputDialog("Digite o ID do livro a ser emprestado:");
        int livroId;
        try {
            livroId = Integer.parseInt(livroIdStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID do livro inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Livro livro = funcao.getLivros().stream().filter(l -> l.getId() == livroId).findFirst().orElse(null);
        if (livro == null) {
            JOptionPane.showMessageDialog(null, "Livro não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nomeUsuario = JOptionPane.showInputDialog("Digite o nome do usuário:");
        Usuario usuario = new Usuario(funcao.getLivros().size() + 1, nomeUsuario);

        funcao.emprestarLivro(livro, usuario);
        JOptionPane.showMessageDialog(null, "Livro emprestado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    private void devolverLivro() {

    } {
        JFrame janela = new JFrame("Menu Principal");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(600, 600);

        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        // Outros botões...

        JButton JBtnSalvarDados = new JButton("Salvar Dados");
        JBtnSalvarDados.setAlignmentX(Component.CENTER_ALIGNMENT);
        JBtnSalvarDados.addActionListener(e -> salvarDados());
        painel.add(JBtnSalvarDados);
        painel.add(Box.createRigidArea(new Dimension(0, 10))); // Adiciona um espaço

        janela.add(painel);

        janela.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(janela,
                        "Dados salvos com sucesso!");
                funcao.salvarDados();
                System.exit(0);
            }
        });

        janela.setVisible(true);
    }

    private void salvarDados() {
        funcao.salvarDados();
        JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

}