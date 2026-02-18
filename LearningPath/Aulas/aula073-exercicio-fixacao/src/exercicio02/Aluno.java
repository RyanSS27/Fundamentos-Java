package exercicio02;

public class Aluno {
    private String nome;
    private double media1Semestre;
    private double media2Semestre;
    private double media3Semestre;
    private boolean aprovado;
    private double notaFinal;

    public Aluno(String nome) {
        this.nome = nome;
        this.aprovado = false;
        this.media1Semestre = 0;
        this.media2Semestre = 0;
        this.media3Semestre = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Caso o semestre seja informado ele insere a média no semestre
    public String mediasSemestre(int sem, double nota1,
                                 double nota2, double nota3) {
        if (sem > 3 || sem < 1) return "Semestre inválido";

        double media = (nota1 + nota2 + nota3)/3;
        switch (sem) {
            case 1 -> this.media1Semestre = media * 0.30d;
            case 2 -> this.media2Semestre = media * 0.35d;
            case 3 -> this.media3Semestre = media * 0.35d;
        }

        setNotaFinal();
        return "Nota atualizada! Média atual: %.2f".formatted(media);
    }

    public double getMedia1Semestre() {
        return media1Semestre;
    }

    public double getMedia2Semestre() {
        return media2Semestre;
    }

    public double getMedia3Semestre() {
        return media3Semestre;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado() {
        if (this.notaFinal >= 6) {
            this.aprovado = true;
        } else {
            this.aprovado = false;
        }
    }

    public String getAprovado() {
        return this.aprovado?"Aprovado":"Reprovado";
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal() {
        this.notaFinal = this.media1Semestre + this.media2Semestre
                + this.media3Semestre;
        this.setAprovado();
    }

    @Override
    public String toString() {
        return """
                Aluno: %s | Nota Final: %.2f | Status: %s
                Média do 1° sem: %.2f
                Média do 2° sem: %.2f
                Média do 3° sem: %.2f
               """.formatted(
                    nome,
                    notaFinal,
                    aprovado ? "PASS" : "FAILED",
                    this.media1Semestre,
                    this.media2Semestre,
                    this.media3Semestre
        );
    }
}
