package br.ufal.ic.p2.myfood;

import br.ufal.ic.p2.myfood.exceptions.*;
import br.ufal.ic.p2.myfood.models.usuario.UsuarioService;
import easyaccept.EasyAccept;

public class Facade {

    UsuarioService usuarioService = new UsuarioService();

    public void zerarSistema (){}

    public String getAtributoUsuario(int id, String atributo) throws UsuarioNaoCadastradoException {
        return usuarioService.getAtributoUsuario(id, atributo);
    }

    public void criarUsuario(String nome, String email, String senha, String endereco) throws EmailJaCadastradoException, NomeInvalidoException, EmailInvalidoException, EnderecoInvalidoException, SenhaInvalidaException {
        usuarioService.criarUsuario(nome, email, senha, endereco);
    }

    public void criarUsuario(String nome, String email, String senha, String endereco, String cpf) throws EmailJaCadastradoException, NomeInvalidoException, EmailInvalidoException, EnderecoInvalidoException, SenhaInvalidaException, CpfInvalidoException {
        usuarioService.criarUsuario(nome, email, senha, endereco, cpf);
    }
}
