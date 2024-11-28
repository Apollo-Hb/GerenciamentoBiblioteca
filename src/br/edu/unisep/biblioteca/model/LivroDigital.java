package br.edu.unisep.biblioteca.model;

public class LivroDigital extends Livro {
    private String formatoArquivo;

    public LivroDigital() { }

    public LivroDigital(int id, String titulo, Autor autor, Genero genero, String formatoArquivo) {
        super(id, titulo, autor, genero);
        this.formatoArquivo = formatoArquivo;
    }

    public String getFormatoArquivo() {
        return formatoArquivo;
    }

    public void setFormatoArquivo(String formatoArquivo) {
        this.formatoArquivo = formatoArquivo;
    }

    @Override
    public String toString() {
        return "LivroDigital{" +
                "formatoArquivo='" + formatoArquivo + '\'' +
                "} " + super.toString();
    }
}
