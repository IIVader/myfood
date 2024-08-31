package br.ufal.ic.p2.myfood.models.usuario;

public class Usuario implements Enderecavel, Identificavel{
    private int id;
    private String nome;
    private String email;
    private String senha;

    public Usuario(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String getEndereco() {
        return "";
    }

    @Override
    public String getCpf() {
        return "";
    }
}
