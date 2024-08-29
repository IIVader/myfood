package br.ufal.ic.p2.myfood.exceptions;

public class EmailJaCadastradoException extends Exception{
    public EmailJaCadastradoException(){
        super("Conta com esse email ja existe");
    }
}
