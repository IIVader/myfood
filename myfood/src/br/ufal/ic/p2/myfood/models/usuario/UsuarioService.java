package br.ufal.ic.p2.myfood.models.usuario;

import br.ufal.ic.p2.myfood.exceptions.UsuarioNaoCadastradoException;

import java.util.HashMap;
import java.util.Map;

public class UsuarioService {

    private int contadorId = 1;

    Map<Integer, Usuario> usuariosPorId = new HashMap<>();

    //Ajeitar essa função, ela deve retornar qualquer atributo requerido do user (usar um switch case)
    public String getAtributoUsuario (int id, String nome) throws UsuarioNaoCadastradoException {
        if(!usuariosPorId.containsValue(id)) {
            throw new UsuarioNaoCadastradoException();
        } else {
            return nome;
        }
    }

    public void criarUsuario(String nome, String email, String senha, String endereco) {
        UsuarioCliente cliente = new UsuarioCliente(this.contadorId, nome, email, senha, endereco);
        usuariosPorId.put(contadorId, cliente);
        this.contadorId += 1;
    }

    public void criarUsuario(String nome, String email, String senha, String endereco, String cpf) {
        UsuarioRestaurante restaurante = new UsuarioRestaurante(this.contadorId, nome, email, senha, endereco, cpf);
        usuariosPorId.put(contadorId, restaurante);
        this.contadorId += 1;
    }
}
