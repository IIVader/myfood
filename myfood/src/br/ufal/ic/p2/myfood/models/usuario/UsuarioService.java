package br.ufal.ic.p2.myfood.models.usuario;

import br.ufal.ic.p2.myfood.exceptions.UsuarioNaoCadastradoException;

import java.util.HashMap;
import java.util.Map;

public class UsuarioService {

    private int contadorId = 1;

    Map<String, Usuario> usuariosPorId = new HashMap<>();

    //Ajeitar essa função, ela deve retornar qualquer atributo requerido do user (usar um switch case)
    public String getAtributoUsuario (int id, String nome) throws UsuarioNaoCadastradoException {
        if(!usuariosPorId.containsValue(id)) {
            throw new UsuarioNaoCadastradoException();
        } else {
            return nome;
        }
    }


}
