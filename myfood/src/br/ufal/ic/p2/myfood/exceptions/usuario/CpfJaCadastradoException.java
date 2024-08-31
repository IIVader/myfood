package br.ufal.ic.p2.myfood.exceptions.usuario;

public class CpfJaCadastradoException extends Exception{
    public CpfJaCadastradoException() {
        super("Cpf já cadastrado");
    }
}
