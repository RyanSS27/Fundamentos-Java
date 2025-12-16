public class Visualizar {
    private Gafanhoto espectador;
    private Video video;

    public Visualizar(Gafanhoto espectador, Video video) {
        this.espectador = espectador;
        this.video = video;
        this.espectador.ganharExp();
        this.espectador.viuMaisUm();
        this.video.setViews();
        this.video.play();
        this.video.pause();
        this.video.like();
    }

    public void avaliar() {
        this.video.setAvaliacao(5);
    }

    public void avaliar(int nota) {
        this.video.setAvaliacao(nota);
    }

    public void avaliar(float porc) {
        int tot = 0;
        if (porc <= 20) {
            tot = 3;
        } else if (porc <= 50) {
            tot = 5;
        } else if (porc <= 90) {
            tot = 8;
        } else {
            tot = 10;
        }
        this.video.setAvaliacao(tot);
    }
}
