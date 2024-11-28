package br.edu.unisep.biblioteca.model;

public class Autor {
    private int id;
    private String nome;

    public Autor() { }

    public Autor(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    public void toObject(String txt) {
        String[] objeto = txt.split(",");
        this.setId(Integer.parseInt(objeto[0]));
        this.setNome(objeto[1]);
    }

    public String toFileString() {
        return this.id + ";" + this.nome;
    }
}