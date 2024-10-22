package hotel;

public class Quarto {
    private int numero;
    private String tipo;
    private double precoDiario;
    private boolean disponivel;

    public Quarto(int numero, String tipo, double precoDiario) {
        this.numero = numero;
        this.tipo = tipo;
        this.precoDiario = precoDiario;
        this.disponivel = true; // Por padrão, o quarto é disponível
    }

    public void exibirDetalhes() {
        System.out.println("Quarto " + numero + ": Tipo " + tipo + ", Preço: R$" + precoDiario + ", Disponível: " + (disponivel ? "Sim" : "Não"));
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getTipo() {
        return tipo;
    }
}