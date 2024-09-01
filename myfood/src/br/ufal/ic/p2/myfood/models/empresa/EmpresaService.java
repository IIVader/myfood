package br.ufal.ic.p2.myfood.models.empresa;

import br.ufal.ic.p2.myfood.exceptions.empresa.*;
import br.ufal.ic.p2.myfood.exceptions.usuario.UsuarioNaoCadastradoException;
import br.ufal.ic.p2.myfood.models.usuario.Usuario;

import java.util.HashMap;
import java.util.Map;

public class EmpresaService {

    private int contadorIdEmpresa = 1;

    private Map<Integer, Empresa> empresasPorId = new HashMap<>();

    private ValidadorDeEmpresa validador = new ValidadorDeEmpresa();

    public int criarEmpresa(String tipoEmpresa, int idDono, String nome, String endereco, String tipoCozinha) throws EmpresaComEsseNomeExisteException, EmpresaComMesmoNomeELocalException, UsuarioNormalNaoAbreEmpresaException, UsuarioNaoCadastradoException {
        validador.validarSeEmpresaJaExiste(empresasPorId, nome, idDono);
        validador.validarEnderecoDaNovaEmpresa(empresasPorId, nome, idDono, endereco);
        validador.validarSeEhUsuarioComum(idDono);

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

    public String getAtributoEmpresa (int idEmpresa, String atributo) throws EmpresaNaoCadastradaException, AtributoInvalidoException {
        Empresa empresa = empresasPorId.get(idEmpresa - 1);

//        for(Empresa empresas : empresasPorId.values()) {
//            System.out.println("[" + empresas.getNome() + ", " + empresas.getEndereco() + ", " + empresas.getId());
//        }

        if(empresa == null) {
            throw new EmpresaNaoCadastradaException();
        } else {
            switch (atributo.toLowerCase()) {
                case "nome":
                    return empresa.getNome();
                case "endereco":
                    return empresa.getEndereco();
                case "tipoCozinha":
                    return empresa.getTipoCozinha();
                default:
                    throw new AtributoInvalidoException();
            }
        }
    }

    public void apagarDados() {
        empresasPorId.clear();
    }
}
