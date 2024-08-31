package br.ufal.ic.p2.myfood.exceptions.empresa;

public class EmpresaComMesmoNomeELocalException extends Exception{
    public EmpresaComMesmoNomeELocalException() {
        super("Proibido cadastrar duas empresas com o mesmo nome e local");
    }
}
