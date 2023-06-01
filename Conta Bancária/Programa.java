import java.util.Scanner;

public class Programa {

    final static String DEPOSITAR = "1";
    final static String SACAR = "2";
    final static String OBTER_SALDO_DISPONIVEL = "3";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Informe seu nome: ");
        String nome = scanner.nextLine();
        System.out.printf("\nInforme o número da conta: ");
        String numeroConta = scanner.nextLine();
        System.out.printf("\nInforme o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        BancoFuncoes contaBanco = new BancoFuncoes(nome, numeroConta, saldoInicial);
        if (contaBanco.obterStatusConta() == BancoFuncoes.STATUS_CRIADO) {
            System.out.println("Conta bancária criada com sucesso");
        }
        imprimirAcoesPrincipais();
        System.out.printf("\nQual ação que você deseja realizar: ");
        scanner.nextLine(); 
        String opcaoEscolhida = scanner.nextLine().toLowerCase();
        String mensagem;
        switch (opcaoEscolhida) {
            case DEPOSITAR:
                System.out.println("Informe o valor a ser depositado");
                double valorDepositado = scanner.nextDouble();
                mensagem = contaBanco.depositar(valorDepositado);
                break;
            case SACAR:
                System.out.println("Informe o valor a ser sacado");
                double valorASacar = scanner.nextDouble();
                mensagem = contaBanco.sacar(valorASacar);
                break;
            case OBTER_SALDO_DISPONIVEL:
                mensagem = "Saldo disponível na conta: " + contaBanco.obterSaldo();
                break;
            default:
                mensagem = "Opção não encontrada";
        }
        System.out.println(mensagem);
        scanner.close();
    }

    public static void imprimirAcoesPrincipais() {
        System.out.printf("%s - Depositar Valor", DEPOSITAR);
        System.out.printf("\n%s - Sacar Valor", SACAR);
        System.out.printf("\n%s - Verificar Valor em Conta", OBTER_SALDO_DISPONIVEL);
    }
}