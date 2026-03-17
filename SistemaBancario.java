import java.util.Scanner;

public class SistemaBancario {
    // Variáveis globais para facilitar o acesso dos métodos
    static double saldo = 0.0;
    static double limiteConsignado = 500.00;
    static Scanner leitor = new Scanner(System.in);

    public static void main(String[] args) {
        String nomeCliente = "Seu Nome Aqui";
        int opcao = 0;

        exibirCabecalho(waleska);

        String menu = """
                \n** Digite sua opção **
                1 - Consultar Saldo
                2 - Depositar Valor
                3 - Sacar Valor
                4 - Sair
                """;

        while (opcao != 4) {
            System.out.print(menu);
            opcao = leitor.nextInt();

            switch (opcao) {
                case 1 -> consultarSaldo();
                case 2 -> realizarDeposito();
                case 3 -> realizarSaque();
                case 4 -> System.out.println("Sistema encerrado. Bons estudos, futuro Engenheiro!");
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    // --- MÉTODOS (FUNÇÕES) ---

    public static void exibirCabecalho(String nome) {
        System.out.println("**********************************");
        System.out.println("Dados do Cliente:");
        System.out.println("Nome: " + nome);
        System.out.println("Limite Disponível: R$ " + String.format("%.2f", limiteConsignado));
        consultarSaldo();
        System.out.println("**********************************");
    }

    public static void consultarSaldo() {
        System.out.println("Saldo atual: R$ " + String.format("%.2f", saldo));
    }

    public static void realizarDeposito() {
        System.out.println("Informe o valor a depositar:");
        double valor = leitor.nextDouble();
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado! " + String.format("Novo saldo: R$ %.2f", saldo));
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public static void realizarSaque() {
        System.out.println("Informe o valor que deseja sacar:");
        double valorSaque = leitor.nextDouble();
        
        // Lógica do Limite Consignado: Saldo Total = Saldo em conta + Limite
        double saldoTotalDisponivel = saldo + limiteConsignado;

        if (valorSaque > saldoTotalDisponivel) {
            System.out.println("Saldo e limite insuficientes.");
        } else {
            saldo -= valorSaque;
            System.out.println("Saque realizado com sucesso!");
            if (saldo < 0) {
                System.out.println("Atenção: Você está usando R$ " + String.format("%.2f", Math.abs(saldo)) + " do seu limite!");
            }
            consultarSaldo();
        }
    }
}

