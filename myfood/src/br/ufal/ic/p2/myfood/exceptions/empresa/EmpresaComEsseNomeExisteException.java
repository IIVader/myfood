package br.ufal.ic.p2.myfood.exceptions.empresa;

public class EmpresaComEsseNomeExisteException extends Exception{
    public EmpresaComEsseNomeExisteException() {
        super("Empresa com esse nome ja existe");
    }
}
