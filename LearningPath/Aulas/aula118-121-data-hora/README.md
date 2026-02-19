# Java Date-Time API (Java 17)
Guia de consulta rápida com foco em boas práticas e nos principais recursos da API moderna de data e hora do Java (`java.time`).

---

## Instanciação de Datas e Horários

### Data e hora atuais
```java
LocalDate date = LocalDate.now();
LocalDateTime dateTime = LocalDateTime.now();
Instant instant = Instant.now(); // Representa um ponto na linha do tempo (UTC)
```

### Criação a partir de Strings (ISO-8601)
```java
LocalDate date = LocalDate.parse("2026-02-11");
LocalDateTime dateTime = LocalDateTime.parse("2050-10-27T20:00");
Instant instant = Instant.parse("1900-10-27T20:30:00Z");
```

### Criação com valores específicos
```java
LocalDateTime dateTime = LocalDateTime.of(2026, 2, 18, 0, 0);
```

---

## Formatação e Parsing

### Definição de padrão customizado
```java
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
LocalDateTime dateTime = LocalDateTime.parse("27/10/2006 12:30", formatter);
```

### Formatação para exibição
A classe `DateTimeFormatter` permite converter objetos de data em representações textuais formatadas.

```java
String formatted = formatter.format(dateTime);
System.out.println(formatted);
```

---

## Conversão entre Fusos Horários

### Local → Instant (UTC)
```java
Instant instant = localDateTime
    .atZone(ZoneId.systemDefault())
    .toInstant();
```

### Instant (UTC) → Local
```java
LocalDateTime dateTime = LocalDateTime.ofInstant(
    instant,
    ZoneId.of("America/Sao_Paulo")
);
```

---

## Operações com Datas
As classes da API `java.time` são imutáveis. Todas as operações retornam novos objetos.

### Adição e subtração
```java
LocalDate nextWeek = baseDate.plusWeeks(1);
LocalDate previousWeek = baseDate.minusWeeks(1);
```

### Uso com unidades temporais
```java
LocalDate nextWeek = baseDate.plus(1, ChronoUnit.WEEKS);
```

### Operações com Instant
`Instant` suporta apenas unidades baseadas em duração (tempo absoluto).

```java
Instant nextWeek = instant.plus(7, ChronoUnit.DAYS);
```

---

## Cálculo de Duração entre Períodos

A classe `Duration` realiza contagens baseadas em segundos e nanossegundos, sendo necessário que as datas utilizadas como range contenham estas informações.
### Utilizando Duration
```java
Duration duration = Duration.between(startDateTime, endDateTime);
```

### Com LocalDate
Para trabalhar com `LocalDate`, é necessário convertê-lo para `LocalDateTime`.

```java
Duration duration = Duration.between(
    startDate.atStartOfDay(),
    endDate.atStartOfDay()
);
```

### Conversão de duração
```java
duration.toDays();
duration.toHours();
duration.toMinutes();
```

---

## Boas Práticas

- Preferir a API `java.time` em vez de `Date` e `Calendar`
- Utilizar `Instant` para representar tempo global (UTC)
- Utilizar `LocalDateTime` para contextos sem fuso horário
- Aplicar `ZoneId` ao lidar com dados sensíveis a fuso
- Evitar mutabilidade: sempre capture o retorno das operações

---

## Referências

- [Documentação Oficial do DateTimeFormatter (Java 17)](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html)
