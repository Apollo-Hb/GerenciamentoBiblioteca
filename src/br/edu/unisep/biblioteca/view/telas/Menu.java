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
    private Usuario usuario;

    public Menu() {
        this.funcao = new Funcao();
        exibirLogin();
    }

    private void exibirLogin() {
        JFrame janelaLogin = new JFrame("Login");
        janelaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaLogin.setSize(400, 200);

        JPanel painelLogin = new JPanel();
        painelLogin.setLayout(new BoxLayout(painelLogin, BoxLayout.Y_AXIS));

        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField(20);

        JLabel lblId = new JLabel("ID:");
        JTextField txtId = new JTextField(20);

        JButton btnLogin = new JButton("Entrar");
        btnLogin.addActionListener(e -> {
            String nome = txtNome.getText();
            String idStr = txtId.getText();
            int id;
            try {
                id = Integer.parseInt(idStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(janelaLogin, "ID inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            usuario = new Usuario(id, nome);
            janelaLogin.dispose();
            exibirMenu();
        });

        painelLogin.add(lblNome);
        painelLogin.add(txtNome);
        painelLogin.add(lblId);
        painelLogin.add(txtId);
        painelLogin.add(Box.createRigidArea(new Dimension(0, 10))); // Adiciona um espaço
        painelLogin.add(btnLogin);

        janelaLogin.add(painelLogin);
        janelaLogin.setVisible(true);
    }

    public void exibirMenu() {
        JFrame janela = new JFrame("Menu Principal - " + usuario.getNome());
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
        if (nomeUsuario == null || nomeUsuario.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome do usuário não pode ser vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario usuario = funcao.getUsuarios().stream()
                .filter(u -> u.getNome().equalsIgnoreCase(nomeUsuario))
                .findFirst()
                .orElse(new Usuario(funcao.getUsuarios().size() + 1, nomeUsuario));

        if (!funcao.getUsuarios().contains(usuario)) {
            funcao.cadastrarUsuario(usuario);
        }

        funcao.emprestarLivro(livro, usuario);
        JOptionPane.showMessageDialog(null, "Livro emprestado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    private void devolverLivro() {
        String emprestimoIdStr = JOptionPane.showInputDialog("Digite o ID do empréstimo a ser devolvido:");
        int emprestimoId;
        try {
            emprestimoId = Integer.parseInt(emprestimoIdStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID do empréstimo inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        funcao.devolverLivro(emprestimoId);
        JOptionPane.showMessageDialog(null, "Livro devolvido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    public void exibir() {
    }
}