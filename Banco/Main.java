package Banco;

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private ArrayList<Conta> listaContas = new ArrayList<>();


    public void criarConta() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.println("Informe o endereço do cliente: ");
        String endereco = scanner.nextLine();

        System.out.println("Informe a profissão do cliente: ");
        String profissao = scanner.nextLine();

        Cliente cliente = new Cliente(nome, endereco, profissao);

        System.out.println("Informe o tipo de conta (Poupança ou Corrente): ");
        String tipoConta = scanner.nextLine();

        System.out.println("Informe o número da agência: ");
        int numeroAgencia = scanner.nextInt();

        System.out.println("Informe o número da conta: ");
        int numeroConta = scanner.nextInt();

        System.out.println("Informe o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        try {
            if (tipoConta.equalsIgnoreCase("Poupança")) {
                ContaPoupanca contaPoupanca = new ContaPoupanca(numeroAgencia, numeroConta, saldoInicial, cliente);
                listaContas.add(contaPoupanca);
            } else if (tipoConta.equalsIgnoreCase("Corrente")) {
                ContaCorrente contaCorrente = new ContaCorrente(numeroAgencia, numeroConta, saldoInicial, cliente);
                listaContas.add(contaCorrente);
            } else {
                System.out.println("Tipo de conta inválido.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao criar conta: " + e.getMessage());
        }
    }

    public void realizarOperacoes() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o número da agência e conta do cliente que deseja enviar dinheiro: ");
        int agenciaOrigem = scanner.nextInt();
        int contaOrigem = scanner.nextInt();

        System.out.println("Informe o número da agência e conta do cliente que receberá o dinheiro: ");
        int agenciaDestino = scanner.nextInt();
        int contaDestino = scanner.nextInt();

        System.out.println("Informe o valor a ser transferido: ");
        double valorTransferencia = scanner.nextDouble();

        for (Conta conta : listaContas) {
            if (conta.getNumeroAgencia() == agenciaOrigem && conta.getNumeroConta() == contaOrigem) {
                for (Conta contaDest : listaContas) {
                    if (contaDest.getNumeroAgencia() == agenciaDestino && contaDest.getNumeroConta() == contaDestino) {
                        conta.transferencia(contaDest, valorTransferencia);
                        return;
                    }
                }
            }
        }

        System.out.println("Conta de origem ou destino não encontrada.");
    }

  
    public void exibirSaldo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o número da agência e conta do cliente para consultar o saldo: ");
        int agencia = scanner.nextInt();
        int conta = scanner.nextInt();

        for (Conta contaCliente : listaContas) {
            if (contaCliente.getNumeroAgencia() == agencia && contaCliente.getNumeroConta() == conta) {
                contaCliente.exibirSaldo();
                return;
            }
        }

        System.out.println("Conta não encontrada.");
    }

   
    public void apresentarMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Criar conta");
            System.out.println("2. Realizar operações");
            System.out.println("3. Exibir saldo");
            System.out.println("0. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    realizarOperacoes();
                    break;
                case 3:
                    exibirSaldo();
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void main(String[] args) {
        Main teste = new Main();
        teste.apresentarMenu();
    }
}