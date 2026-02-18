import java.util.concurrent.ThreadLocalRandom;

public class Livro implements Leitura {
    private String titulo;
    private String autor;
    private int totPaginas;
    private int pagAtual;
    private boolean aberto;
    private Pessoa leitor;

    public Livro(String tit, String aut, int tot, Pessoa p) {
        this.titulo = tit;
        this.autor = aut;
        this.totPaginas = tot;
        this.pagAtual = 0;
        this.aberto = false;
        this.leitor = p;
    }

    public String detalhes() {
        return """
                =======================
                   DETALHES DO LIVRO
                =======================
                Título:             %s
                Autor:              %s
                Total de páginas:   %d
                Está aberto:        %b
                Leitor:             %s
                Página atual:       %d
                """.formatted(this.titulo, this.autor, this.totPaginas, this.aberto, this.leitor.getNome(), this.pagAtual);
    }

    private String setEstado(boolean acao) {
        this.aberto = acao;
        return (this.aberto ? "Livro \"%s\" foi aberto".formatted(this.titulo): "Livro \"%s\" foi fechado".formatted(this.titulo));
    }

    @Override
    public String abreFecha() {
        if (this.aberto) {
            this.pagAtual = 0;
            return setEstado(false);
        } else {
            this.pagAtual = 1;
            return setEstado(true);
        }
    }

    @Override
    public String avancarPag() {
        if (pagAtual < this.totPaginas && this.aberto) {
            this.pagAtual++;
            return "Passou para a pág %d".formatted(this.pagAtual);
        } else {
            return "Não foi possível avançar.";
        }
    }

    @Override
    public String voltarPag() {
        if (pagAtual > 0 && this.aberto) {
            this.pagAtual--;
            return (pagAtual == 0? this.abreFecha(): "Passou para a pág %d".formatted(this.pagAtual));

        } else {
            return "Não foi possível voltar.";
        }
    }

    @Override
    public String folhear() {
        if(this.aberto && pagAtual < this.totPaginas) {
            this.pagAtual = ThreadLocalRandom.current().nextInt(this.pagAtual, this.totPaginas + 1);
            return  "Você folheou até a página %d".formatted(this.pagAtual);
        } else {
            return "Não foi possível folhear";
        }
    }
}
