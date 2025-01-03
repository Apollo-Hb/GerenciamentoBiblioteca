package br.edu.unisep.biblioteca.model;

public class Usuario {
    private int id;
    private String nome;

    public Usuario() { }

    public Usuario(int id, String nome) {
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
        return "Usuario{" +
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
