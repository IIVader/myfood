package br.ufal.ic.p2.myfood.models.usuario;

public class UsuarioCliente extends Usuario {

    private String endereco;

    public UsuarioCliente(int id, String nome, String email, String senha, String endereco) {
        super(id, nome, email, senha);
        this.endereco = endereco;
    }

    @Override
    public String getEndereco() {
        return endereco;
    }
}
