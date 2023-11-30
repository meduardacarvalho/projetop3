package Banco;

public class ContaCorrente extends Conta {
    private static final double TAXA_MANUTENCAO = 50.0;

    public ContaCorrente(int numeroAgencia, int numeroConta, double saldo, Cliente cliente) {
        super(numeroAgencia, numeroConta, saldo, cliente);
    }

    @Override
    public void deposito(double valor) {
        
        super.deposito(valor);

        
        super.saque(TAXA_MANUTENCAO);
        System.out.println("Depósito na Conta Corrente realizado com sucesso.");
    }

    @Override
    public void exibirSaldo() {
       
        super.saque(TAXA_MANUTENCAO);
        super.exibirSaldo();
    }


    public double simularOperacao(int meses) {
        double saldoFinal = getSaldo() - (TAXA_MANUTENCAO * meses);
        System.out.println("Simulação de operação da Conta Corrente por " + meses + " meses.");
        System.out.println("Saldo final após descontar taxas: R$" + saldoFinal);
        return saldoFinal;
    }
}
