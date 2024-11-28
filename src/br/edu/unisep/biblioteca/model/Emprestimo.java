package br.edu.unisep.biblioteca.model;

import java.time.LocalDate;

public class Emprestimo {
    private int id;
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo() { }

    public Emprestimo(int id, Livro livro, Usuario usuario, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.id = id;
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "id=" + id +
                ", livro=" + livro +
                ", usuario=" + usuario +
                ", dataEmprestimo=" + dataEmprestimo +
                ", dataDevolucao=" + dataDevolucao +
                '}';
    }

    public void toObject(String txt) {
        String[] objeto = txt.split(",");
        this.setId(Integer.parseInt(objeto[0]));
        this.livro = new LivroFisico(); // Exemplo para simplificação
        this.livro.setId(Integer.parseInt(objeto[1]));
        this.usuario = new Usuario();
        this.usuario.setId(Integer.parseInt(objeto[2]));
        this.setDataEmprestimo(LocalDate.parse(objeto[3]));
        this.setDataDevolucao(LocalDate.parse(objeto[4]));
    }

    public String toFileString() {
        return this.id + ";" + this.livro.getId() + ";" + this.usuario.getId() + ";" + this.dataEmprestimo + ";" + this.dataDevolucao;
    }
}
