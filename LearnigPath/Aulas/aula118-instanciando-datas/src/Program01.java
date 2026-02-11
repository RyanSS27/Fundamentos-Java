import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
/*
    - Como salvar a data atual
    - Salvar datas via Strings
 */
public class Program01 {
    public static void main(String[] args) {
        // Horário local
        LocalDate d01 = LocalDate.now();
        // Horário local com hora, minutos, segundos e microssegundos
        LocalDateTime d02 = LocalDateTime.now();
        // Horário global com hora, minutos, segundos e microssegundos
        Instant d03 = Instant.now(); // Note que tem o 'Z' no final

        // Salvando horários por Strings
        LocalDate d04 = LocalDate.parse("2026-02-11");
        LocalDateTime d05 = LocalDateTime.parse("2050-10-27T20:00");
        Instant d06 = Instant.parse("1900-10-27T20:30:00Z");

        System.out.println(d01);
        System.out.println(d02);
        System.out.println(d03);
        System.out.println(d04);
        System.out.println(d05);
        System.out.println(d06);
    }
}
