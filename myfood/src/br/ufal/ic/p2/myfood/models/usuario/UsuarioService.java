package br.ufal.ic.p2.myfood.models.usuario;

import br.ufal.ic.p2.myfood.exceptions.EmailJaCadastradoException;
import br.ufal.ic.p2.myfood.exceptions.UsuarioNaoCadastradoException;

import java.util.HashMap;
import java.util.Map;

public class UsuarioService {

    private int contadorId = 1;

    Map<Integer, Usuario> usuariosPorId = new HashMap<>();
    
    public String getAtributoUsuario (int id, String atributo) throws UsuarioNaoCadastradoException {
        Usuario usuario = usuariosPorId.get(id);

        if(usuario == null) {
            throw new UsuarioNaoCadastradoException();
        } else {
            switch (atributo.toLowerCase()) {
                case "nome":
                    return usuario.getNome();
                case "email":
                    return usuario.getEmail();
                case "endereco":
                    return usuario.getEndereco();
                default:
                    throw new IllegalArgumentException("Atributo desconhecido: " + atributo);
            }
        }
    }

    public void criarUsuario(String nome, String email, String senha, String endereco) throws EmailJaCadastradoException {
        for(Usuario usuario : usuariosPorId.values()) {
            if (usuario.getEmail().equals(email)) {
                throw new EmailJaCadastradoException();
            }
        }

            UsuarioCliente cliente = new UsuarioCliente(this.contadorId, nome, email, senha, endereco);
            usuariosPorId.put(contadorId, cliente);
            this.contadorId += 1;
    }

    public void criarUsuario(String nome, String email, String senha, String endereco, String cpf) throws EmailJaCadastradoException {
            for(Usuario usuario : usuariosPorId.values()) {
                if (usuario.getEmail().equals(email)) {
                    throw new EmailJaCadastradoException();
                }
            }

            UsuarioRestaurante restaurante = new UsuarioRestaurante(this.contadorId, nome, email, senha, endereco, cpf);
            usuariosPorId.put(contadorId, restaurante);
            this.contadorId += 1;
    }
}
