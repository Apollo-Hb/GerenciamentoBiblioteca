package br.edu.unisep.biblioteca.model;

public abstract class Livro {
    private int id;
    private String titulo;
    private Autor autor;
    private Genero genero;

    public Livro() { }

    public Livro(int id, String titulo, Autor autor, Genero genero) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", genero=" + genero +
                '}';
    }

    public void toObject(String txt) {
        String[] objeto = txt.split(",");
        this.setId(Integer.parseInt(objeto[0]));
        this.setTitulo(objeto[1]);
        this.autor = new Autor();
        this.autor.setId(Integer.parseInt(objeto[2]));
        this.genero = new Genero();
        this.genero.setId(Integer.parseInt(objeto[3]));
    }

    public String toFileString() {
        return this.id + ";" + this.titulo + ";" + this.autor.getId() + ";" + this.genero.getId();
    }
}


