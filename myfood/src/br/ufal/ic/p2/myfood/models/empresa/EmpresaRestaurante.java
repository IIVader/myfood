package br.ufal.ic.p2.myfood.models.empresa;

public class EmpresaRestaurante extends Empresa{
    private String tipoCozinha;

    public EmpresaRestaurante(int id, String nome, String endereco, int idDoDono, String tipoCozinha) {
        super(id, nome, endereco, idDoDono);
        this.tipoCozinha = tipoCozinha;
    }

    @Override
    public String getTipoCozinha() {
        return tipoCozinha;
    }
}
