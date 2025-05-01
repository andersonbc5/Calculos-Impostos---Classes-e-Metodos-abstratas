package entities;

public class Invividual extends Taxpayes {

    private Double gastosSaude;

    public Invividual() {
        super();
    }

    public Invividual(String name, Double anualinCome, Double gastosSaude) {
        super(name, anualinCome);
        this.gastosSaude = gastosSaude;
    }

    public Double getGastosSaude() {
        return gastosSaude;
    }

    public void setGastosSaude(Double gastosSaude) {
        this.gastosSaude = gastosSaude;
    }

    @Override
    public double tax() {

        if(getRendaAnual() < 20000.0){
            return getRendaAnual() * 0.15 - gastosSaude * 0.5;
        }else{
            return getRendaAnual() * 0.25 - gastosSaude * 0.5;
        }
        
        
    }

}