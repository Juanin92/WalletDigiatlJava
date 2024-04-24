package wallet;

public interface OperacionBancaria {

    public void Depositar(double monto);

    public void Transferir(double monto,Cuenta cuenta);

    public void ConsultaSaldo();

    public void RetiroDinero(double monto);
}