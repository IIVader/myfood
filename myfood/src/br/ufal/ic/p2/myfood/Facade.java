package br.ufal.ic.p2.myfood;

import br.ufal.ic.p2.myfood.exceptions.EmailJaCadastradoException;
import br.ufal.ic.p2.myfood.exceptions.UsuarioNaoCadastradoException;
import br.ufal.ic.p2.myfood.models.usuario.UsuarioService;
import easyaccept.EasyAccept;

public class Facade {

    UsuarioService usuarioService = new UsuarioService();

    public void zerarSistema (){}

    public String getAtributoUsuario(int id, String nome) throws UsuarioNaoCadastradoException {
        return usuarioService.getAtributoUsuario(id, nome);
    }

    public void criarUsuario(String nome, String email, String senha, String endereco) throws EmailJaCadastradoException {
        usuarioService.criarUsuario(nome, email, senha, endereco);
    }

    public void criarUsuario(String nome, String email, String senha, String endereco, String cpf) throws EmailJaCadastradoException {
        usuarioService.criarUsuario(nome, email, senha, endereco, cpf);
    }
}
