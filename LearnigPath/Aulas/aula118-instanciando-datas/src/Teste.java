import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Teste {
    public static void main(String[] args) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm v").withZone(ZoneId.systemDefault());
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("v").withZone(ZoneId.systemDefault());
        LocalDate date = LocalDate.now();

        Instant dataGMT = Instant.now();
        System.out.println(date.format(format));
        System.out.println(format2.format(dataGMT));
        // Guardando a data formatada em uma String
        String locale = format2.format(dataGMT);
        System.out.println(locale);

    }
}
