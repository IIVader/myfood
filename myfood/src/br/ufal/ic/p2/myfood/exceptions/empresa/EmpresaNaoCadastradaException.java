package br.ufal.ic.p2.myfood.exceptions.empresa;

public class EmpresaNaoCadastradaException extends Exception{
    public EmpresaNaoCadastradaException() {
        super("Empresa nao cadastrada");
    }
}
