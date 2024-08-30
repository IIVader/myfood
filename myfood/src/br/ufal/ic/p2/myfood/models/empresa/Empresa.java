package br.ufal.ic.p2.myfood.models.empresa;

public class Empresa {
    private int id;
    private String nome;
    private String endereco;
    private int idDono;

    public Empresa(int id, String nome, String endereco, int idDono) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.idDono = idDono;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getIdDono() {
        return idDono;
    }

    public String getTipoCozinha() {
        return null;
    }

}
