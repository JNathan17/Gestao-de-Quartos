package models;

import java.util.Scanner;

public class MenuQuartos {
    private OperacoesQuarto operacoesQuarto;
    private Scanner scanner;

    public MenuQuartos(OperacoesQuarto operacoesQuarto) {
        this.operacoesQuarto = operacoesQuarto;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int escolha;

        System.out.println("\n==== Menu de Operações ====");
        System.out.println("1. Inserir Quarto");
        System.out.println("2. Alterar informaçoes do Quarto");
        System.out.println("3. Excluir Quarto");
        System.out.println("4. Duplicar Quarto");
        System.out.println("5. Listar Quartos");
        System.out.println("6. Gerar/Atualizar Relatório de Quartos");
        System.out.println("7. Sair");
        System.out.print("Escolha uma opção: ");
        escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                operacoesQuarto.inserirQuarto();
                break;
            case 2:
                operacoesQuarto.alterarQuarto();
                break;
            case 3:
                operacoesQuarto.excluirQuarto();
                break;
            case 4:
                operacoesQuarto.duplicarQuarto();
                break;
            case 5:
                operacoesQuarto.listarQuartos();
                break;
            case 6:
                System.out.println("Gerando Relatório de Quartos...");
                GeradorRelatorio.gerarRelatorio(operacoesQuarto.getQuartos());
                System.out.println("Relatório de Quartos gerado com sucesso!");
                break;
            case 7:
                System.out.println("Saindo do programa. Até logo!");
                return;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
