package Banco;

public class ContaPoupanca extends Conta {
    private static final double TAXA_RENDIMENTO = 0.05;

    public ContaPoupanca(int numeroAgencia, int numeroConta, double saldo, Cliente cliente) {
        super(numeroAgencia, numeroConta, saldo, cliente);
    }

    public double getTaxaRendimento() {
        return TAXA_RENDIMENTO;
    }

    @Override
    public void deposito(double valor) {
    
        super.deposito(valor);

        
        double rendimento = getSaldo() * TAXA_RENDIMENTO;
        super.deposito(rendimento);

        System.out.println("Depósito na Conta Poupança realizado com sucesso.");
        System.out.println("Rendimento após depósito: R$" + rendimento);
    }

    @Override
    public void exibirSaldo() {
        
        double rendimento = getSaldo() * TAXA_RENDIMENTO;
        super.deposito(rendimento);
        super.exibirSaldo();
        System.out.println("Rendimento do mês: R$" + rendimento);
    }

   
    public double simularOperacao(int meses) {
        double saldoFinal = getSaldo() + (getSaldo() * TAXA_RENDIMENTO * meses);
        System.out.println("Simulação de operação da Conta Poupança por " + meses + " meses.");
        System.out.println("Saldo final após rendimento: R$" + saldoFinal);
        return saldoFinal;
    }
}
