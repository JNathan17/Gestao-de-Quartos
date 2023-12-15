package test;

import models.GeradorRelatorio;
import models.OperacoesQuarto;
import models.Quarto;

import java.io.*;
import java.util.Map;

public class RelatorioTest
{
    public static void main(String[] args) throws IOException
    {
        var operacoes = new OperacoesQuarto();

        operacoes.inserirQuarto();
        GeradorRelatorio.gerarRelatorio(operacoes.getQuartos());
        System.out.println("<<<<<<<<<<TESTE>>>>>>>>>>");
        verificaLinhas(operacoes.getQuartos());

        operacoes.alterarQuarto();
        GeradorRelatorio.gerarRelatorio(operacoes.getQuartos());
        System.out.println("<<<<<<<<<<TESTE>>>>>>>>>>");
        verificaLinhas(operacoes.getQuartos());

        operacoes.duplicarQuarto();
        GeradorRelatorio.gerarRelatorio(operacoes.getQuartos());
        System.out.println("<<<<<<<<<<TESTE>>>>>>>>>>");
        verificaLinhas(operacoes.getQuartos());

        operacoes.excluirQuarto();
        GeradorRelatorio.gerarRelatorio(operacoes.getQuartos());
        System.out.println("<<<<<<<<<<TESTE>>>>>>>>>>");
        verificaLinhas(operacoes.getQuartos());
    }


    private static void verificaLinhas(Map<Integer, Quarto> quartos) throws IOException
    {
        File file;
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        String linha;

        try
        {
            file = new File("src/main/resources/relatorio_quartos.txt");
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Impossível ler arquivo: " + e.getMessage());
        }

        int contador = 0;

        for (Quarto quarto : quartos.values())
        {
            contador++;

            String idOnString = "ID do Quarto: " + quarto.getId();
            linha = bufferedReader.readLine();
            Boolean verificaId = idOnString.equals(linha);

            String numeroOnString = "Número do Quarto: " + quarto.getNumero();
            linha = bufferedReader.readLine();
            Boolean verificaNumero = numeroOnString.equals(linha);

            String capacidadeOnString = "Capacidade: " + quarto.getCapacidade();
            linha = bufferedReader.readLine();
            Boolean verificaCapacidade = capacidadeOnString.equals(linha);

            String valorHospedagemOnString = "Valor da Hospedagem: " + quarto.getValorHospedagem();
            linha = bufferedReader.readLine();
            Boolean verificaValorHospedagem = valorHospedagemOnString.equals(linha);

            String statusOnString = "Status do Quarto: " + quarto.getStatus();
            linha = bufferedReader.readLine();
            Boolean verificaStatus = statusOnString.equals(linha);

            String ultimaLinha = "----------------------";
            linha = bufferedReader.readLine();
            Boolean verificaUltimaLinha = ultimaLinha.equals(linha);

            if(verificaId && verificaNumero && verificaCapacidade && verificaValorHospedagem && verificaStatus && verificaUltimaLinha)
                System.out.println("Item " + contador + " verificado!");
            else
                System.err.println("Item " + contador + " incongruente!");
        }
    }
}
