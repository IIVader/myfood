package br.ufal.ic.p2.myfood.exceptions.usuario;

public class SenhaInvalidaException extends Exception {
    public SenhaInvalidaException() {
        super("Senha invalido");
    }
}
