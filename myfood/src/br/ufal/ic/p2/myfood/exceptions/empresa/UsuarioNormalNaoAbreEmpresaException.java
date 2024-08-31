package br.ufal.ic.p2.myfood.exceptions.empresa;

public class UsuarioNormalNaoAbreEmpresaException extends Exception{
    public UsuarioNormalNaoAbreEmpresaException() {
        super("Usuario nao pode criar uma empresa");
    }
}
