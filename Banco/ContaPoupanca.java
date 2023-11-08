package Banco;

public class ContaPoupanca extends Conta{
private double taxaderendimento;

    public ContaPoupanca(int numeroagencia, int numeroconta, double saldo, Cliente cliente) {
        super(numeroagencia, numeroconta, saldo, cliente);
   
    }
    public double simularOperacao(int meses) {
        
        return meses;
        
    }
}
