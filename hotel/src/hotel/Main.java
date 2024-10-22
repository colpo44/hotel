package hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();

        // Formato de data "DD-MM-YYYY"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Adicionar alguns quartos ao hotel
        hotel.adicionarQuarto(new Quarto(101, "solteiro", 150.00));
        hotel.adicionarQuarto(new Quarto(102, "casal", 250.00));
        hotel.adicionarQuarto(new Quarto(201, "suite", 350.00));

        // Menu simples
        while (true) {
            System.out.println("\n=== Sistema de Gerenciamento de Hotel ===");
            System.out.println("1. Verificar quartos disponíveis");
            System.out.println("2. Fazer reserva");
            System.out.println("3. Check-in");
            System.out.println("4. Check-out");
            System.out.println("5. Relatório de ocupação");
            System.out.println("6. Histórico de reservas");
            System.out.println("0. Sair");

            int opcao = sc.nextInt();
            sc.nextLine();  // Consumir a quebra de linha

            if (opcao == 0) {
                break;
            }

            switch (opcao) {
                case 1:
                    hotel.gerarRelatorioOcupacao();
                    break;
                case 2:
                    System.out.print("Nome do hóspede: ");
                    String nomeHospede = sc.nextLine();
                    
                    // Inserção de data no formato "DD-MM-YYYY"
                    System.out.print("Data de check-in (DD-MM-YYYY): ");
                    String checkInStr = sc.nextLine();
                    LocalDate checkIn = LocalDate.parse(checkInStr, formatter);
                    
                    System.out.print("Data de check-out (DD-MM-YYYY): ");
                    String checkOutStr = sc.nextLine();
                    LocalDate checkOut = LocalDate.parse(checkOutStr, formatter);

                    System.out.print("Número de quartos: ");
                    int numQuartos = sc.nextInt();
                    sc.nextLine();  // Consumir a quebra de linha
                    System.out.print("Tipo de quarto (solteiro, casal, suite): ");
                    String tipoQuarto = sc.nextLine();

                    hotel.fazerReserva(nomeHospede, checkIn, checkOut, numQuartos, tipoQuarto);
                    break;
                case 3:
                    System.out.print("Nome do hóspede para check-in: ");
                    String nomeCheckIn = sc.nextLine();
                    hotel.checkIn(nomeCheckIn);
                    break;
                case 4:
                    System.out.print("Nome do hóspede para check-out: ");
                    String nomeCheckOut = sc.nextLine();
                    hotel.checkOut(nomeCheckOut);
                    break;
                case 5:
                    hotel.gerarRelatorioOcupacao();
                    break;
                case 6:
                    System.out.print("Nome do hóspede: ");
                    String nomeHist = sc.nextLine();
                    hotel.gerarHistoricoReservas(nomeHist);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

      
    }
}