import javax.swing.text.DateFormatter;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
/*
    Imprimindo com formatos padronizados
    Doc: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html
*/
public class Program03 {
    public static void main(String[] args) {
        DateTimeFormatter formatoDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Cria um padrão/Pattern
        DateTimeFormatter formatoInstant = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm v").withZone(ZoneId.systemDefault());

        LocalDate data = LocalDate.now();
        Instant dataGMT = Instant.now();

        System.out.println(data.format(formatoDate));
        System.out.println(formatoDate.format(data));
        System.out.println(formatoInstant.format(dataGMT));
    }
}
