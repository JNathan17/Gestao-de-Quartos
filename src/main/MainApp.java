package main;

import models.MenuQuartos;
import models.OperacoesQuarto;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        OperacoesQuarto operacoesQuarto = new OperacoesQuarto();
        MenuQuartos menuQuartos = new MenuQuartos(operacoesQuarto);
        Scanner scanner = new Scanner(System.in);

        do {
            menuQuartos.exibirMenu();

                System.out.print("Deseja realizar outra operação? (S/N): ");


        } while (scanner.next().equalsIgnoreCase("S"));
    }
}
