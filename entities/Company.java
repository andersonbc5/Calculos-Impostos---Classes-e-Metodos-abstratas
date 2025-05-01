package entities;

public class Company extends Taxpayes {

    private int numeroFuncionarios;

    public Company() {
        super();
    }

    public Company(String name, Double rendaAnual, int numeroFuncionarios) {
        super(name, rendaAnual);
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public int getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(int numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }

    @Override
    public double tax() {
        if (numeroFuncionarios > 10){
            return getRendaAnual() * 0.14;
        }else{
            return getRendaAnual() * 0.16;
        }
    }

}
