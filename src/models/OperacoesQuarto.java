package models;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OperacoesQuarto {
    private Map<Integer, Quarto> quartos;
    private Scanner scanner;

    public OperacoesQuarto() {
        this.quartos = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void inserirQuarto() {
        do {
            System.out.println("\nCadastro de Quarto:");
            int id;
            do {
                System.out.print("Informe o ID do quarto: ");
                id = scanner.nextInt();
                if (idExistente(id)) {
                    System.out.println("ID já existente. Escolha outro ID.");
                }
            } while (idExistente(id));

            scanner.nextLine();

            try {
                int numero;
                do {
                    System.out.print("Informe o número do quarto: ");
                    numero = scanner.nextInt();

                    if (numeroExistente(numero)) {
                        System.out.println("\nNúmero do quarto já existente. Escolha outro número.\n");
                    }

                } while (numeroExistente(numero));

                System.out.print("Informe a capacidade do quarto: ");
                int capacidade = scanner.nextInt();
                System.out.print("Informe o valor da hospedagem: ");
                double valorHospedagem = scanner.nextDouble();
                scanner.nextLine(); // Consumir a quebra de linha

                String status = escolherStatus();

                Quarto quarto = new Quarto(id, numero, capacidade, valorHospedagem, status);
                quartos.put(id, quarto);

                System.out.println("Quarto cadastrado com sucesso!");

            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao cadastrar quarto: " + e.getMessage());
            }

            System.out.print("Deseja inserir outro quarto? (S/N): ");
        } while (scanner.next().equalsIgnoreCase("S"));

        System.out.print("Deseja ver a lista de quartos cadastrados? (S/N): ");
        if (scanner.next().equalsIgnoreCase("S")) {
            listarQuartos();
        }
    }

    public void alterarQuarto() {
        System.out.print("Informe o ID do quarto que deseja alterar: ");
        int id = scanner.nextInt();

        if (quartos.containsKey(id)) {
            Quarto quarto = quartos.get(id);
            quarto.consultarQuarto();

            System.out.println("\nEscolha uma opção para alterar:");
            System.out.println("1. Número do quarto");
            System.out.println("2. Capacidade do quarto");
            System.out.println("3. Valor da hospedagem");
            System.out.println("4. Status do quarto");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Informe o novo número do quarto: ");
                    int novoNumero = scanner.nextInt();
                    quarto.setNumero(novoNumero);
                    System.out.println("Número do quarto alterado com sucesso!");
                    break;

                case 2:
                    System.out.print("Informe a nova capacidade do quarto: ");
                    int novaCapacidade = scanner.nextInt();
                    quarto.setCapacidade(novaCapacidade);
                    System.out.println("Capacidade do quarto alterada com sucesso!");
                    break;

                case 3:
                    System.out.print("Informe o novo valor da hospedagem: ");
                    double novoValorHospedagem = scanner.nextDouble();
                    quarto.setValorHospedagem(novoValorHospedagem);
                    System.out.println("Valor da hospedagem alterado com sucesso!");
                    break;

                case 4:
                    String novoStatus = escolherStatus();
                    quarto.setStatus(novoStatus);
                    System.out.println("Status do quarto alterado com sucesso!");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } else {
            System.out.println("Quarto não encontrado.");
        }
    }

    public void excluirQuarto() {
        System.out.print("Informe o ID do quarto que deseja excluir: ");
        int id = scanner.nextInt();

        if (quartos.containsKey(id)) {
            Quarto quarto = quartos.get(id);
            quarto.consultarQuarto();

            System.out.print("Deseja realmente excluir este quarto? (S/N): ");
            if (scanner.next().equalsIgnoreCase("S")) {
                quartos.remove(id);
                System.out.println("Quarto excluído com sucesso!");
            } else {
                System.out.println("Operação de exclusão cancelada.");
            }
        } else {
            System.out.println("Quarto não encontrado.");
        }
    }

    public void duplicarQuarto() {
        System.out.print("Informe o ID do quarto que deseja duplicar: ");
        int id = scanner.nextInt();

        if (quartos.containsKey(id)) {
            Quarto quartoOriginal = quartos.get(id);
            quartoOriginal.consultarQuarto();

            int novoId = gerarNovoId();
            Quarto quartoNovo = new Quarto(novoId, quartoOriginal.getNumero(), quartoOriginal.getCapacidade(),
                    quartoOriginal.getValorHospedagem(), quartoOriginal.getStatus());

            quartos.put(novoId, quartoNovo);

            System.out.println("Quarto duplicado com sucesso!");
            quartoNovo.consultarQuarto();
        } else {
            System.out.println("Quarto não encontrado.");
        }
    }

    public void listarQuartos() {
        if (quartos.isEmpty()) {
            System.out.println("Nenhum quarto cadastrado.");
        } else {
            System.out.println("Lista de Quartos:");
            for (Quarto quarto : quartos.values()) {
                quarto.consultarQuarto();
                System.out.println("----------------------");
            }
        }
    }

    private boolean idExistente(int id) {
        return quartos.containsKey(id);
    }

    private boolean numeroExistente(int numero) {
        for (Quarto quarto : quartos.values()) {
            if (quarto.getNumero() == numero) {
                return true;
            }
        }
        return false;
    }

    private String escolherStatus() {
        System.out.println("Escolha o novo status do quarto:");

        System.out.println("1. Disponível");
        System.out.println("2. Indisponível");
        System.out.println("3. Ocupado");
        System.out.println("4. Em reforma/manutenção");
        System.out.println("5. Necessita limpeza");

        int escolha;

        do {
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    return "disponível";
                case 2:
                    return "indisponível";
                case 3:
                    return "ocupado";
                case 4:
                    return "em reforma/manutenção";
                case 5:
                    return "necessita limpeza";
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (true);
    }

    private int gerarNovoId() {
        int novoId;
        do {
            novoId = (int) (Math.random() * 1000);
        } while (idExistente(novoId));
        return novoId;
    }

    public Map<Integer, Quarto> getQuartos() {
        return quartos;
    }

    public void setQuartos(Map<Integer, Quarto> quartos) {
        this.quartos = quartos;
    }
}
