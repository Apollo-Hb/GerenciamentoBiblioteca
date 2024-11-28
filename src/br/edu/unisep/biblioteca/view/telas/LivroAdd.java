package br.edu.unisep.biblioteca.view.telas;

import br.edu.unisep.biblioteca.model.*;
import br.edu.unisep.biblioteca.util.Funcao;

import javax.swing.*;

public class LivroAdd {

    public LivroAdd(Funcao funcao) {
        String titulo = JOptionPane.showInputDialog("Digite o título do livro:");
        if (titulo == null || titulo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Título do livro não pode ser vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String autorIdStr = JOptionPane.showInputDialog("Digite o ID do autor:");
        int autorId;
        try {
            autorId = Integer.parseInt(autorIdStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID do autor inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Autor autor = funcao.getAutores().stream().filter(a -> a.getId() == autorId).findFirst().orElse(null);
        if (autor == null) {
            JOptionPane.showMessageDialog(null, "Autor não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String generoIdStr = JOptionPane.showInputDialog("Digite o ID do gênero:");
        int generoId;
        try {
            generoId = Integer.parseInt(generoIdStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID do gênero inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Genero genero = funcao.getGeneros().stream().filter(g -> g.getId() == generoId).findFirst().orElse(null);
        if (genero == null) {
            JOptionPane.showMessageDialog(null, "Gênero não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] opcoes = {"Digital", "Físico"};
        int tipoLivro = JOptionPane.showOptionDialog(null, "O livro é digital ou físico?", "Tipo de Livro",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

        Livro livro;
        if (tipoLivro == 0) {
            String formatoArquivo = JOptionPane.showInputDialog("Digite o formato do arquivo:");
            livro = new LivroDigital(funcao.getLivros().size() + 1, titulo, autor, genero, formatoArquivo);
        } else if (tipoLivro == 1) {
            String paginasStr = JOptionPane.showInputDialog("Digite a quantidade de páginas:");
            int quantidadePaginas;
            try {
                quantidadePaginas = Integer.parseInt(paginasStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Quantidade de páginas inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            livro = new LivroFisico(funcao.getLivros().size() + 1, titulo, autor, genero, quantidadePaginas);
        } else {
            JOptionPane.showMessageDialog(null, "Tipo de livro inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        funcao.cadastrarLivro(livro);
    }
}
