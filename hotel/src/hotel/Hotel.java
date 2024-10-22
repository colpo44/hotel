package hotel;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel {
    private ArrayList<Quarto> quartos;
    private ArrayList<Reserva> reservas;

    public Hotel() {
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public void fazerReserva(String nomeHospede, LocalDate checkIn, LocalDate checkOut, int numeroQuartos, String tipoQuarto) {
        // Verifica a disponibilidade dos quartos do tipo solicitado
        ArrayList<Quarto> quartosDisponiveis = new ArrayList<>();
        for (Quarto q : quartos) {
            if (q.getTipo().equals(tipoQuarto) && q.isDisponivel()) {
                quartosDisponiveis.add(q);
            }
        }

        if (quartosDisponiveis.size() >= numeroQuartos) {
            Reserva reserva = new Reserva(nomeHospede, checkIn, checkOut, numeroQuartos, tipoQuarto);
            reservas.add(reserva);

            // Atualiza a disponibilidade dos quartos reservados
            for (int i = 0; i < numeroQuartos; i++) {
                quartosDisponiveis.get(i).setDisponivel(false);
            }
            System.out.println("Reserva realizada com sucesso para " + nomeHospede + ".");
        } else {
            System.out.println("Não há quartos suficientes disponíveis do tipo " + tipoQuarto + ".");
        }
    }

    public void checkIn(String nomeHospede) {
        for (Reserva reserva : reservas) {
            if (reserva.getNomeHospede().equals(nomeHospede)) {
                System.out.println("Check-in realizado para " + nomeHospede + ".");
                return;
            }
        }
        System.out.println("Reserva não encontrada para " + nomeHospede + ".");
    }

    public void checkOut(String nomeHospede) {
        for (Reserva reserva : reservas) {
            if (reserva.getNomeHospede().equals(nomeHospede)) {
                for (Quarto q : quartos) {
                    if (q.getTipo().equals(reserva.getTipoQuarto())) {
                        q.setDisponivel(true);  // Libera os quartos
                    }
                }
                System.out.println("Check-out realizado para " + nomeHospede + ".");
                return;
            }
        }
        System.out.println("Reserva não encontrada para " + nomeHospede + ".");
    }

    public void gerarRelatorioOcupacao() {
        System.out.println("Relatório de Ocupação:");
        for (Quarto q : quartos) {
            String status = q.isDisponivel() ? "Disponível" : "Ocupado";
            q.exibirDetalhes();
            System.out.println("Status: " + status);
        }
    }

    public void gerarHistoricoReservas(String nomeHospede) {
        System.out.println("Histórico de Reservas para " + nomeHospede + ":");
        for (Reserva reserva : reservas) {
            if (reserva.getNomeHospede().equals(nomeHospede)) {
                reserva.exibirDetalhes();
            }
        }
    }
}