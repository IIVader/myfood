package br.ufal.ic.p2.myfood.models.usuario;

import br.ufal.ic.p2.myfood.exceptions.*;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ValidadorDeCampos {

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public void validarDados(String nome, String email, String senha, String endereco) throws NomeInvalidoException, EmailInvalidoException, SenhaInvalidaException, EnderecoInvalidoException {
        if(nome == null || nome.trim().isEmpty()) throw new NomeInvalidoException();
        if(email == null || email.trim().isEmpty() || !validarEmail(email)) throw new EmailInvalidoException();
        if(senha == null || senha.trim().isEmpty()) throw new SenhaInvalidaException();
        if(endereco == null || endereco.trim().isEmpty()) throw new EnderecoInvalidoException();
    }

    public void validarCpf(String cpf) throws CpfInvalidoException {
        if(cpf != null) {
            if(cpf.length() != 14) throw new CpfInvalidoException();
        } else if(cpf == null || cpf.trim().isEmpty()) throw new CpfInvalidoException();
    }

    private boolean validarEmail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
}