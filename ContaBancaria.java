import java.util.Scanner;

public class ContaBancaria {
    // Atributos
    private String titular;
    private double saldo;

    // Construtor
    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // Métodos
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Valor de depósito inválido!");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente!");
        } else {
            System.out.println("Valor de saque inválido!");
        }
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual: R$ " + saldo);
    }

    // Método para exibir informações da conta
    public void exibirInformacoes() {
        System.out.println("Titular: " + titular);
        consultarSaldo();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Dados iniciais
        System.out.print("Digite o nome do titular da conta: ");
        String titular = sc.nextLine();
        System.out.print("Digite o saldo inicial da conta: ");
        double saldoInicial = sc.nextDouble();

        // Criação da conta bancária
        ContaBancaria conta = new ContaBancaria(titular, saldoInicial);

        int opcao;
        do {
            // Menu de opções
            System.out.println("\nMenu:");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Exibir Informações");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    conta.consultarSaldo();
                    break;
                case 2:
                    System.out.print("Digite o valor a ser depositado: ");
                    double deposito = sc.nextDouble();
                    conta.depositar(deposito);
                    break;
                case 3:
                    System.out.print("Digite o valor a ser sacado: ");
                    double saque = sc.nextDouble();
                    conta.sacar(saque);
                    break;
                case 4:
                    conta.exibirInformacoes();
                    break;
                case 5:
                    System.out.println("Saindo... Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        sc.close();
    }
}
