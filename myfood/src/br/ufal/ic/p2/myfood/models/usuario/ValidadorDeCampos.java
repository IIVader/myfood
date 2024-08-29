package br.ufal.ic.p2.myfood.models.usuario;

import br.ufal.ic.p2.myfood.exceptions.*;

public class ValidadorDeCampos {

    public void validarDados(String nome, String email, String senha, String endereco) throws NomeInvalidoException, EmailInvalidoException, SenhaInvalidaException, EnderecoInvalidoException {
        if(nome == null || nome.trim().isEmpty()) throw new NomeInvalidoException();
        if(email == null || email.trim().isEmpty()) throw new EmailInvalidoException();
        if(senha == null || senha.trim().isEmpty()) throw new SenhaInvalidaException();
        if(endereco == null || endereco.trim().isEmpty()) throw new EnderecoInvalidoException();
    }

    public void validarCpf(String cpf) throws CpfInvalidoException {
        if(cpf != null) {
            if(cpf.length() != 14) throw new CpfInvalidoException();
        } else if(cpf == null || cpf.trim().isEmpty()) throw new CpfInvalidoException();
    }
}
