package Banco;

public class Conta {
    private int numeroagencia;
    private int numeroconta;
    private double saldo;
    private Cliente cliente;

    public Conta(int numeroagencia, int numeroconta, double saldo, Cliente cliente) {
        this.numeroagencia = numeroagencia;
        this.numeroconta = numeroconta;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public int getNumeroagencia() {
        return numeroagencia;
    }
    public void setNumeroagencia(int numeroagencia) {
        this.numeroagencia = numeroagencia;
    }
    public int getNumeroconta() {
        return numeroconta;
    }
    public void setNumeroconta(int numeroconta) {
        this.numeroconta = numeroconta;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
   public void deposito (double valor) {

   }
    public void saque (double valor) {

   }
    public void transferencia (double valor, Conta outraConta) {

   }
     public void exibirsaldo() {

          }
}


    

