package br.ufal.ic.p2.myfood.models.empresa;

import br.ufal.ic.p2.myfood.exceptions.empresa.EmpresaComEsseNomeExisteException;
import br.ufal.ic.p2.myfood.exceptions.empresa.EmpresaComMesmoNomeELocalException;
import br.ufal.ic.p2.myfood.exceptions.empresa.UsuarioNormalNaoAbreEmpresaException;
import br.ufal.ic.p2.myfood.exceptions.usuario.UsuarioNaoCadastradoException;
import br.ufal.ic.p2.myfood.models.usuario.Usuario;
import br.ufal.ic.p2.myfood.models.usuario.UsuarioService;

import java.util.Map;

public class ValidadorDeEmpresa {

    private UsuarioService usuarioService = new UsuarioService();

    public void validarSeEmpresaJaExiste(Map<Integer, Empresa> empresasPorId, String nome, int idDono) throws EmpresaComEsseNomeExisteException {
        for(Empresa empresa: empresasPorId.values()) {
            if(empresa.getNome().equals(nome) && empresa.getIdDono() != idDono) throw new EmpresaComEsseNomeExisteException();
        }
    }

    public void validarEnderecoDaNovaEmpresa(Map<Integer, Empresa> empresasPorId, String nome, int idDono, String endereco) throws EmpresaComMesmoNomeELocalException {
        for(Empresa empresa: empresasPorId.values()) {
            if(empresa.getNome().equals(nome) && empresa.getIdDono() == idDono && empresa.getEndereco().equals(endereco)) throw new EmpresaComMesmoNomeELocalException();
        }
    }

    public void validarSeEhUsuarioComum(int idDono) throws UsuarioNormalNaoAbreEmpresaException {
    }

}
