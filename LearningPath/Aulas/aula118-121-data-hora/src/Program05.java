import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Program05 {
    /*
        - Convertendo data locais em globais
     */
    public static void main(String[] args) {
        /*
            Você deve dizer a qual fuso a data está submetida para que ele
            converta para o padrão GMT
         */
        LocalDateTime date  = LocalDateTime.parse("2026-02-18T14:53:10");
        Instant dataGlobal = date.atZone(ZoneId.systemDefault()).toInstant();

        System.out.println(dataGlobal);
        System.out.println(date);
    }
}
