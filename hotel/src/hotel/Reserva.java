import java.time.LocalDate;

public class Reserva {
    private String nomeHospede;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int numeroQuartos;
    private String tipoQuarto;

    public Reserva(String nomeHospede, LocalDate checkIn, LocalDate checkOut, int numeroQuartos, String tipoQuarto) {
        this.nomeHospede = nomeHospede;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numeroQuartos = numeroQuartos;
        this.tipoQuarto = tipoQuarto;
    }

    public void exibirDetalhes() {
        System.out.println("Hóspede: " + nomeHospede + ", Check-in: " + checkIn + ", Check-out: " + checkOut + ", Quartos reservados: " + numeroQuartos + ", Tipo de quarto: " + tipoQuarto);
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }
}