# Fundamentos Java
 Meus aprendizados em Java
 <h1>Java Date-Time API (Java 17)</h1>
<p>Guia de consulta rápida com foco em boas práticas e nos principais recursos da API moderna de data e hora do Java (<code>java.time</code>).</p>

<h2>Instanciação de Datas e Horários</h2>

<h3>Data e hora atuais</h3>
<pre><code class="language-java">
LocalDate date = LocalDate.now();
LocalDateTime dateTime = LocalDateTime.now();
Instant instant = Instant.now(); // Representa um ponto na linha do tempo (UTC)
</code></pre>

<h3>Criação a partir de Strings (ISO-8601)</h3>
<pre><code class="language-java">
LocalDate date = LocalDate.parse("2026-02-11");
LocalDateTime dateTime = LocalDateTime.parse("2050-10-27T20:00");
Instant instant = Instant.parse("1900-10-27T20:30:00Z");
</code></pre>

<h3>Criação com valores específicos</h3>
<pre><code class="language-java">
LocalDateTime dateTime = LocalDateTime.of(2026, 2, 18, 0, 0);
</code></pre>

---

<h2>Formatação e Parsing</h2>

<h3>Definição de padrão customizado</h3>
<pre><code class="language-java">
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
LocalDateTime dateTime = LocalDateTime.parse("27/10/2006 12:30", formatter);
</code></pre>

<h3>Formatação para exibição</h3>
<p>A classe <code>DateTimeFormatter</code> permite converter objetos de data em representações textuais formatadas.</p>

<pre><code class="language-java">
String formatted = formatter.format(dateTime);
System.out.println(formatted);
</code></pre>

---

<h2>Conversão entre Fusos Horários</h2>

<h3>Local → Instant (UTC)</h3>
<pre><code class="language-java">
Instant instant = localDateTime
    .atZone(ZoneId.systemDefault())
    .toInstant();
</code></pre>

<h3>Instant (UTC) → Local</h3>
<pre><code class="language-java">
LocalDateTime dateTime = LocalDateTime.ofInstant(
    instant,
    ZoneId.of("America/Sao_Paulo")
);
</code></pre>

---

<h2>Operações com Datas</h2>
<p>As classes da API <code>java.time</code> são imutáveis. Todas as operações retornam novos objetos.</p>

<h3>Adição e subtração</h3>
<pre><code class="language-java">
LocalDate nextWeek = baseDate.plusWeeks(1);
LocalDate previousWeek = baseDate.minusWeeks(1);
</code></pre>

<h3>Uso com unidades temporais</h3>
<pre><code class="language-java">
LocalDate nextWeek = baseDate.plus(1, ChronoUnit.WEEKS);
</code></pre>

<h3>Operações com Instant</h3>
<p><code>Instant</code> suporta apenas unidades baseadas em duração (tempo absoluto).</p>

<pre><code class="language-java">
Instant nextWeek = instant.plus(7, ChronoUnit.DAYS);
</code></pre>

---

<h2>Cálculo de Duração entre Períodos</h2>

<h3>Utilizando Duration</h3>
<pre><code class="language-java">
Duration duration = Duration.between(startDateTime, endDateTime);
</code></pre>

<h3>Com LocalDate</h3>
<p>Para trabalhar com <code>LocalDate</code>, é necessário convertê-lo para <code>LocalDateTime</code>.</p>

<pre><code class="language-java">
Duration duration = Duration.between(
    startDate.atStartOfDay(),
    endDate.atStartOfDay()
);
</code></pre>

<h3>Conversão de duração</h3>
<pre><code class="language-java">
duration.toDays();
duration.toHours();
duration.toMinutes();
</code></pre>

---

<h2>Boas Práticas</h2>
<ul>
  <li>Preferir a API <code>java.time</code> em vez de <code>Date</code> e <code>Calendar</code></li>
  <li>Utilizar <code>Instant</code> para representar tempo global (UTC)</li>
  <li>Utilizar <code>LocalDateTime</code> para contextos sem fuso horário</li>
  <li>Aplicar <code>ZoneId</code> ao lidar com dados sensíveis a fuso</li>
  <li>Evitar mutabilidade: sempre capture o retorno das operações</li>
</ul>

