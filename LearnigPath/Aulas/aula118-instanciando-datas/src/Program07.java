import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Program07 {
    /*
        - Como capturar a duração ente 2 períodos
    */
    public static void main(String[] args) {
        LocalDateTime data1 = LocalDateTime.parse("2026-02-18T00:00");
        LocalDateTime data2 = LocalDateTime.parse("2026-04-01T00:00");

        Duration  duration = Duration.between(data1, data2);
        System.out.println(duration.toDays());

        /*
            Caso queira uma duração entre 2 LocalDate, deve especificar a hora
            e segundos.
            Pode-se usar o .atStartOfDay() que considera time 00:00 ou converter.
        */

        LocalDate agora = LocalDate.now();
        LocalDate birthDayDate = LocalDate.parse("2026-10-27");
        Duration duration1 =  Duration.between(agora.atStartOfDay(), birthDayDate.atStartOfDay());
        System.out.println(duration1.toDays());
        System.out.println(duration1.toHours());
        System.out.println(duration1.toMinutes());
    }
}
