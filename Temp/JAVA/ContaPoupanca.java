
public class ContaPoupanca extends ContasBancaria  {

     public ContaPoupanca(int id, String titular, double saldo) {
        super(id, titular,  saldo);
    }

    public boolean render(double taxa) {
        if(taxa <= 0){
            return false;
        }
        else{
            taxa =  getSaldo() * taxa / 100;
            depositar(taxa);

            return true;
        }
    }
    
}
    

