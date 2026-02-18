import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Defina o formato de entrada
        // 2. Parse da String para LocalDateTime
        // 3. Converta para Instant (usando ZoneId "America/Sao_Paulo")
        // 4. Converta do Instant para ZonedDateTime ou LocalDateTime nos outros fusos
        // 5. Imprima formatado

        /*
         * DESAFIO PRÁTICO: Agendador de Reunião Global
         * * Objetivo: Manipular fuso horários e formatação.
                        * * 1. Entrada e Parsing:
         * - Data/Hora simulada: "20/07/2022 15:00"
                        * - Converter esta String para um objeto LocalDateTime.
         * * 2. Conversão para Linha do Tempo Global (Instant):
         * - Converter o LocalDateTime para Instant, considerando que ele
         * está no fuso de São Paulo ("America/Sao_Paulo").
                        * * 3. Conversão para Outros Fusos:
         * - Com base no Instant gerado, obter os horários locais de:
         * a) Portugal ("Europe/Lisbon")
                        * b) Tóquio ("Asia/Tokyo")
                        * * 4. Formatação de Saída:
         * - Para o horário de Tóquio, exibir os dados separadamente:
         * "A reunião será no dia {dia} do mês {mês} às {hora} horas."
         */
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatoLocal = DateTimeFormatter.ofPattern("dd/MM/yyyyHH:mm");

        System.out.println("Digite a data da reunião (dd/mm/yyyy):");
        String entradaDataHora = "27/10/2026";// sc.nextLine();
        System.out.println("Digite o horário da reunião (hh/mm):");
        entradaDataHora += "13:30";// sc.nextLine();

        LocalDateTime dataHoraLocal = LocalDateTime.parse(entradaDataHora, formatoLocal);

        ZoneId fuso = ZoneId.systemDefault();

        Instant dataHoraGlobal = dataHoraLocal.atZone(fuso).toInstant();
        System.out.println(dataHoraGlobal);
    }
}
