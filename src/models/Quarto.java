package models;

public class Quarto {
    private int id;
    private int numero;
    private int capacidade;
    private double valorHospedagem;
    private String status;


    public Quarto() {

    }

    public Quarto(int id, int numero, int capacidade, double valorHospedagem, String status) {
        validarNumeroQuarto(numero);
        validarStatus(status);

        this.id = id;
        this.numero = numero;
        this.capacidade = capacidade;
        this.valorHospedagem = valorHospedagem;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        validarNumeroQuarto(numero);
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public double getValorHospedagem() {
        return valorHospedagem;
    }

    public void setValorHospedagem(double valorHospedagem) {
        this.valorHospedagem = valorHospedagem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        validarStatus(status);
        this.status = status;
    }

    public void consultarQuarto() {
        System.out.println("ID do quarto: " + id);
        System.out.println("Número do Quarto: " + numero);
        System.out.println("Capacidade: " + capacidade);
        System.out.println("Valor da Hospedagem: " + valorHospedagem);
        System.out.println("Status: " + status);
    }

    private void validarNumeroQuarto(int numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException("Número do quarto deve ser maior que zero.");
        }
    }

    private void validarStatus(String status) {
        if (!status.equalsIgnoreCase("disponível") &&
                !status.equalsIgnoreCase("indisponível") &&
                !status.equalsIgnoreCase("ocupado") &&
                !status.equalsIgnoreCase("em reforma/manutenção") &&
                !status.equalsIgnoreCase("necessita limpeza")) {
            throw new IllegalArgumentException("Status inválido.");
        }
    }
}
