import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Evento {
    private String nome;
    private Instant dataInicio;
    private Instant dataTermino;
    private Duration duracao;


    public Evento(String nome, LocalDateTime dataInicio, LocalDateTime dataTermino) {
        this.nome = nome;
        this.dataInicio = dataInicio.atZone(ZoneId.systemDefault()).toInstant();
        this.dataTermino = dataTermino.atZone(ZoneId.systemDefault()).toInstant();
        this.duracao = Duration.between(dataInicio, dataTermino);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Instant getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Instant dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Instant getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Instant dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
