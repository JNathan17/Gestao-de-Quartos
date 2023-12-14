package models;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


public class GeradorRelatorio {


    public static void gerarRelatorio(Map<Integer, Quarto> quartos) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/main/resources/relatorio_quartos.txt"))) {
            for (Quarto quarto : quartos.values()) {
                writer.println("ID do Quarto: " + quarto.getId());
                writer.println("Número do Quarto: " + quarto.getNumero());
                writer.println("Capacidade: " + quarto.getCapacidade());
                writer.println("Valor da Hospedagem: " + quarto.getValorHospedagem());
                writer.println("Status do Quarto: " + quarto.getStatus());
                writer.println("----------------------");
            }
            System.out.println("Relatório gerado com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao gerar o relatório: " + e.getMessage());
        }
    }
}
