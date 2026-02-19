import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("""
                ================================
                       AGENDE SUA REUNIÃO
                ================================
                Informe a data e hora de inicio
                no formato (dd/MM/yyyy HH:mm):
                """);
        LocalDateTime dataInicio = LocalDateTime.parse(sc.nextLine(), formatterDateTime);
        System.out.println("""
                Informe a data e hora de termino
                no formato (dd/MM/yyyy HH:mm):
                """);
        LocalDateTime dataTermino = LocalDateTime.parse(sc.nextLine(), formatterDateTime);
        System.out.println("Informe o nome do evento:");
        String nome = sc.nextLine();

        if (!validarDatas(dataInicio, dataTermino)) {
            System.out.println("Datas inválidas, tente novamente.");
            return;
        }

        ZoneId userZone = ZoneId.systemDefault();

        Evento evento = new Evento(nome, dataInicio, dataTermino);
        long totalMinutes = evento.getDuracao().toMinutes();
        long hours = totalMinutes / 60;
        long minutes = totalMinutes % 60;

        System.out.println(
                "Duração:\n"
                        + hours + ":"
                        + minutes
        );

        LocalDateTime inicio = LocalDateTime.ofInstant(
                evento.getDataInicio(),
                userZone
        );

        System.out.println("Reunião marcada para: "
                + formatterDateTime.format(inicio));

        // Simulação: remarcando para a semana subsequente:
        LocalDateTime novoInicio = LocalDateTime.ofInstant(
                evento.getDataInicio(), userZone
        ).plusWeeks(1);

        LocalDateTime novoTermino = LocalDateTime.ofInstant(
                evento.getDataTermino(), userZone
        ).plusWeeks(1);

        Evento eventoRemarcado = new Evento(evento.getNome(), novoInicio, novoTermino);

        LocalDateTime inicioRemarcado  = LocalDateTime.ofInstant(
                eventoRemarcado.getDataInicio(), userZone
        );

        System.out.println(
                "Reunião remarcada para: " +
                formatterDateTime.format(inicioRemarcado)
        );
        sc.close();
    }

    public static boolean validarDatas(LocalDateTime dataInicio, LocalDateTime dataTermino) {
        return !Duration.between(dataInicio, dataTermino).isNegative();
    }
}
