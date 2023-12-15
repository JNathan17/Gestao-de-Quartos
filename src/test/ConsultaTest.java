package test;

import models.OperacoesQuarto;

public class ConsultaTest {
    public static void main(String[] args) {
        var operacoes = new OperacoesQuarto();

        operacoes.inserirQuarto();
        System.out.println("<<<<<<<<<<TESTE>>>>>>>>>>");
        operacoes.listarQuartos();

        operacoes.alterarQuarto();
        System.out.println("<<<<<<<<<<TESTE>>>>>>>>>>");
        operacoes.listarQuartos();

        operacoes.duplicarQuarto();
        System.out.println("<<<<<<<<<<TESTE>>>>>>>>>>");
        operacoes.listarQuartos();

        operacoes.excluirQuarto();
        System.out.println("<<<<<<<<<<TESTE>>>>>>>>>>");
        operacoes.listarQuartos();
    }
}
