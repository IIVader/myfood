package br.ufal.ic.p2.myfood.models.empresa;

import br.ufal.ic.p2.myfood.exceptions.empresa.EmpresaComEsseNomeExisteException;
import br.ufal.ic.p2.myfood.exceptions.empresa.EmpresaComMesmoNomeELocalException;
import br.ufal.ic.p2.myfood.exceptions.empresa.UsuarioNormalNaoAbreEmpresaException;
import br.ufal.ic.p2.myfood.exceptions.usuario.UsuarioNaoCadastradoException;
import br.ufal.ic.p2.myfood.models.usuario.Usuario;

import java.util.HashMap;
import java.util.Map;

public class EmpresaService {

    private int contadorIdEmpresa = 1;

    private Map<Integer, Empresa> empresasPorId = new HashMap<>();

    private ValidadorDeEmpresa validador = new ValidadorDeEmpresa();

    public int criarEmpresa(String tipoEmpresa, int idDono, String nome, String endereco, String tipoCozinha) throws EmpresaComEsseNomeExisteException, EmpresaComMesmoNomeELocalException, UsuarioNormalNaoAbreEmpresaException {
        validador.validarSeEmpresaJaExiste(empresasPorId, nome, idDono);
        validador.validarEnderecoDaNovaEmpresa(empresasPorId, nome, idDono, endereco);

        if(tipoEmpresa.equals("restaurante")) {
            Empresa novoRestaurante = new EmpresaRestaurante(contadorIdEmpresa, nome, endereco, idDono, tipoCozinha);
            empresasPorId.put(contadorIdEmpresa, novoRestaurante);
        }

        contadorIdEmpresa += 1;

        return contadorIdEmpresa;
    }

    public String getEmpresasDoUsuario (int idDono) {
        StringBuilder nomeDasEmpresas = new StringBuilder();
        nomeDasEmpresas.append("{[");

        for(Empresa empresa : empresasPorId.values()) {
            if(empresa.getIdDono() == idDono){
                nomeDasEmpresas.append("[").append(empresa.getNome()).append(",").append(" ").append(empresa.getEndereco()).append("]").append(",").append(" ");
            }
        }

        if (nomeDasEmpresas.length() > 2) { // > 2 para garantir que haja os "]}" do final
            nomeDasEmpresas.setLength(nomeDasEmpresas.length() - 2);
        }

        nomeDasEmpresas.append("]}");

        return nomeDasEmpresas.toString();
    }

    public void apagarDados() {
        empresasPorId.clear();
    }
}
