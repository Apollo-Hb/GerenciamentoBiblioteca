package br.edu.unisep.biblioteca.model;

public class LivroFisico extends Livro {
    private int quantidadePaginas;

    public LivroFisico() { }

    public LivroFisico(int id, String titulo, Autor autor, Genero genero, int quantidadePaginas) {
        super(id, titulo, autor, genero);
        this.quantidadePaginas = quantidadePaginas;
    }

    public int getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public void setQuantidadePaginas(int quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }

    @Override
    public String toString() {
        return "LivroFisico{" +
                "quantidadePaginas=" + quantidadePaginas +
                "} " + super.toString();
    }
}
