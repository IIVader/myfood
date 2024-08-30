package br.ufal.ic.p2.myfood.models.empresa;

import br.ufal.ic.p2.myfood.exceptions.empresa.EmpresaComEsseNomeExisteException;
import br.ufal.ic.p2.myfood.models.usuario.Usuario;

import java.util.HashMap;
import java.util.Map;

public class EmpresaService {

    private int contadorIdEmpresa = 1;

    Map<Integer, Empresa> empresasPorId = new HashMap<>();

    public int criarEmpresa(String tipoEmpresa, int idDono, String nome, String endereco, String tipoCozinha) throws EmpresaComEsseNomeExisteException {
        for(Empresa empresa: empresasPorId.values()) {
            if(empresa.getNome().equals(nome) && empresa.getIdDono() != idDono) throw new EmpresaComEsseNomeExisteException();
        }

        if(tipoEmpresa.equals("restaurante")) {
            Empresa novoRestaurante = new EmpresaRestaurante(contadorIdEmpresa, nome, endereco, idDono, tipoCozinha);
            empresasPorId.put(contadorIdEmpresa, novoRestaurante);
        }

        contadorIdEmpresa += 1;

        return contadorIdEmpresa;
    }

}
