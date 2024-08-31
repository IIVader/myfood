package br.ufal.ic.p2.myfood;

import br.ufal.ic.p2.myfood.exceptions.empresa.EmpresaComEsseNomeExisteException;
import br.ufal.ic.p2.myfood.exceptions.empresa.EmpresaComMesmoNomeELocalException;
import br.ufal.ic.p2.myfood.exceptions.empresa.UsuarioNormalNaoAbreEmpresaException;
import br.ufal.ic.p2.myfood.exceptions.usuario.*;
import br.ufal.ic.p2.myfood.models.empresa.EmpresaService;
import br.ufal.ic.p2.myfood.models.usuario.UsuarioService;

public class Facade {

    UsuarioService usuarioService = new UsuarioService();
    EmpresaService empresaService = new EmpresaService();

    public void zerarSistema (){
        usuarioService.apagarDados();
        empresaService.apagarDados();
    }

    public String getAtributoUsuario(int id, String atributo) throws UsuarioNaoCadastradoException {
        return usuarioService.getAtributoUsuario(id, atributo);
    }

    public void criarUsuario(String nome, String email, String senha, String endereco) throws EmailJaCadastradoException, NomeInvalidoException, EmailInvalidoException, EnderecoInvalidoException, SenhaInvalidaException {
        usuarioService.criarUsuario(nome, email, senha, endereco);
    }

    public void criarUsuario(String nome, String email, String senha, String endereco, String cpf) throws EmailJaCadastradoException, NomeInvalidoException, EmailInvalidoException, EnderecoInvalidoException, SenhaInvalidaException, CpfInvalidoException, CpfJaCadastradoException {
        usuarioService.criarUsuario(nome, email, senha, endereco, cpf);
    }

    public int login(String email, String senha) throws LoginInvalidoException {
        return usuarioService.login(email, senha);
    }

    public int criarEmpresa(String tipoEmpresa, int idDono, String nome, String endereco, String tipoCozinha) throws EmpresaComEsseNomeExisteException, EmpresaComMesmoNomeELocalException, UsuarioNaoCadastradoException, UsuarioNormalNaoAbreEmpresaException {
        return empresaService.criarEmpresa(tipoEmpresa, idDono, nome, endereco, tipoCozinha);
    }

    public String getEmpresasDoUsuario(int idDono) {
        return empresaService.getEmpresasDoUsuario(idDono);
    }

    public void encerrarSistema(){}
}