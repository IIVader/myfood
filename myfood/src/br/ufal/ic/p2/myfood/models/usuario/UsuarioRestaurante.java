package br.ufal.ic.p2.myfood.models.usuario;

public class UsuarioRestaurante extends Usuario {

    private String endereco;
    private String cpf;

    public UsuarioRestaurante(int id, String nome, String email, String senha, String endereco, String cpf) {
        super(id, nome, email, senha);
        this.endereco = endereco;
        this.cpf = cpf;
    }
}
