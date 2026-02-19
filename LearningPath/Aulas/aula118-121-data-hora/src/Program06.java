import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Program06 {
    /*
        - Operações com LocalDate, LocalDateTime e Instant
     */
    public static void main(String[] args) {
        /*
            Datas em java são imutáveis, logo, para saber quando foi o dia
            anterior a alguma data - por exemplo - deve-se criar uma nova
            variável para abrigar o fruto da operação
        */

        // Semana que antecede e sucede uma data
        LocalDate dataBase = LocalDate.parse("2026-02-18");
        LocalDate dataParaSoma = LocalDate.parse("2026-04-01");
        LocalDate semanaSeguinte = dataBase.plusWeeks(1);
        LocalDate semanaAnterior = dataBase.minusWeeks(1);

        System.out.println(dataBase);
        System.out.println(semanaSeguinte);
        System.out.println(semanaAnterior);

        System.out.println("=========================");

        /*
            Instant, como sempre, sendo um pé no saco. Gosta de ser o diferentão
         */
        Instant dataBaseInstant = Instant.now();
        // Não pode ser passado unidades WEEKS, MONTHS or YEARS, pois
        // só suporta unidades de tempo baseadas em duração (dias, horas, minutos, segundos, etc.)
        Instant instantProximaSemana = dataBaseInstant.plus(7, ChronoUnit.DAYS);
        System.out.println("Semana seguinte com Instant: " + instantProximaSemana);
        System.out.println("Semana anterior com Instant: " + instantProximaSemana);
    }
}
