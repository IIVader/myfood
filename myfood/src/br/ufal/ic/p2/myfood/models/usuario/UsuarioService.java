package br.ufal.ic.p2.myfood.models.usuario;

import br.ufal.ic.p2.myfood.exceptions.usuario.*;

import java.util.HashMap;
import java.util.Map;

public class UsuarioService {

    private int contadorId = 1;
    private ValidadorDeCampos validador = new ValidadorDeCampos();

    private Map<Integer, Usuario> usuariosPorId = new HashMap<>();

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
                case "cpf":
                    return usuario.getCpf();
                case "senha":
                    return usuario.getSenha();
                default:
                    throw new IllegalArgumentException("Atributo desconhecido: " + atributo);
            }
        }
    }

    public void criarUsuario(String nome, String email, String senha, String endereco) throws EmailJaCadastradoException, NomeInvalidoException, EmailInvalidoException, EnderecoInvalidoException, SenhaInvalidaException {
        validador.validarDados(nome, email, senha, endereco);

        for(Usuario usuario : usuariosPorId.values()) {
            if (usuario.getEmail().equals(email)) {
                throw new EmailJaCadastradoException();
            }
        }

        UsuarioCliente cliente = new UsuarioCliente(this.contadorId, nome, email, senha, endereco);
        usuariosPorId.put(contadorId, cliente);
        this.contadorId += 1;
    }

    public void criarUsuario(String nome, String email, String senha, String endereco, String cpf) throws EmailJaCadastradoException, NomeInvalidoException, EmailInvalidoException, EnderecoInvalidoException, SenhaInvalidaException, CpfInvalidoException, CpfJaCadastradoException {
        validador.validarDados(nome, email, senha, endereco);
        validador.validarCpf(cpf);

        for(Usuario usuario : usuariosPorId.values()) {
            if (usuario.getEmail().equals(email)) {
                throw new EmailJaCadastradoException();
            }
//            if(usuario.getCpf().equals(cpf)){
//                throw new CpfJaCadastradoException();
//            }
        }

        UsuarioDonoEmpresa restaurante = new UsuarioDonoEmpresa(this.contadorId, nome, email, senha, endereco, cpf);
        usuariosPorId.put(contadorId, restaurante);
        this.contadorId += 1;
    }

    public int login(String email, String senha) throws LoginInvalidoException {
        validador.validarLogin(email, senha);

        for(Usuario usuario : usuariosPorId.values()) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return usuario.getId();
            }
        }
        throw new LoginInvalidoException();
    }

    public void apagarDados() {
        usuariosPorId.clear();
    }
}