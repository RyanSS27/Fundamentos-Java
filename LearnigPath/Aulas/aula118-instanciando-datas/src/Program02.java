import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
    - Como salvar datas em formatos customizados
    - Instanciar data passando yyyy, MM, dd como argumentos
 */
public class Program02 {
    public static void main(String[] args) {
        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDate dataFormatada = LocalDate.parse("27/10/2026", formato1);
        LocalDateTime dataHoraFormatada = LocalDateTime.parse("27/10/2026 12:00", formato2);

        System.out.println(dataFormatada);
        System.out.println(dataHoraFormatada);

        System.out.println("=====================");

        LocalDate date = LocalDate.of(2025, 10, 27);
        LocalDateTime dateTime = LocalDateTime.of(2025, 4, 9, 12, 0, 5);
        System.out.println(date);
        System.out.println(dateTime);
    }
}
