public class Livro implements Leitura {
    private String titulo;
    private String autor;
    private int totPaginas;
    private int pagAtual;
    private boolean aberto;
    Pessoa leitor;

    public Livro(String tit, String aut, int tot, int pag, boolean abe, Pessoa p) {
        this.titulo = tit;
        this.autor = aut;
        this.totPaginas = tot;
        this.pagAtual = pag;
        this.aberto = abe;
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
                Leitor:             %s
                Página atual:       %d
                """.formatted(this.titulo, this.autor, this.totPaginas, this.pagAtual, this.aberto, this.leitor.getNome();
    }

    @Override
    public void abrir() {

    }

    @Override
    public void fechar() {

    }

    @Override
    public void avancarPag() {

    }

    @Override
    public void voltarPag() {

    }
}
