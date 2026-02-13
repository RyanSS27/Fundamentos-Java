import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Program04 {
    /*
        - Convertendo data-hora global para local
        - Como retirar o dia, hora, minuto, etc da data
    */
    public static void main(String[] args) {
        Instant dataGlobal = Instant.parse("2019-08-30T01:30:00Z");
        /*
            NOTA:
            Para poder converter, é necessário passar o fuso horário ao qual a data
            estará representada, pois mesmo que o LocalDate não guarde a informação, ela é
            necessária para se calcular o dia com base nas diferenças de fuso.

            A dataGlobal está armazenada seguindo o fuso de Londres (GMT padrão), com 3h de
            diferença para o nosso
        */
        LocalDate dataLocalSistema = LocalDate.ofInstant(dataGlobal, ZoneId.systemDefault());
        LocalDate dataLocalPorZona = LocalDate.ofInstant(dataGlobal, ZoneId.of("America/Sao_Paulo"));
        System.out.println(dataGlobal);

        System.out.println(dataLocalSistema);
        System.out.println(dataLocalPorZona);

        // Exibindo informações
        LocalDateTime localDateTimePorZona = LocalDateTime.ofInstant(dataGlobal, ZoneId.of("America/Sao_Paulo"));
        System.out.printf(
                "Dia %d/%s, as %d:%d",
                localDateTimePorZona.getDayOfMonth(),
                localDateTimePorZona.getMonth(),
                localDateTimePorZona.getHour(),
                localDateTimePorZona.getMinute()
        );
    }
}
