package br.ufal.ic.p2.myfood;

import br.ufal.ic.p2.myfood.exceptions.empresa.EmpresaComEsseNomeExisteException;
import br.ufal.ic.p2.myfood.exceptions.usuario.*;
import br.ufal.ic.p2.myfood.models.empresa.EmpresaService;
import br.ufal.ic.p2.myfood.models.usuario.UsuarioService;

public class Facade {

    UsuarioService usuarioService = new UsuarioService();
    EmpresaService empresaService = new EmpresaService();

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

    public int login(String email, String senha) throws LoginInvalidoException {
        return usuarioService.login(email, senha);
    }

    public int criarEmpresa(String tipoEmpresa, int idDono, String nome, String endereco, String tipoCozinha) throws EmpresaComEsseNomeExisteException {
        return empresaService.criarEmpresa(tipoEmpresa, idDono, nome, endereco, tipoCozinha);
    }

    public void encerrarSistema(){}
}