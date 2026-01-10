package oficina;

public abstract class Relatorio {
    private String placa;
    private String possivelCausa;
    private String descricao;
    private int nivelDano;

    public Relatorio(String placa, String possivelCausa, String descricao, int nivelDano) {
        this.placa = placa;
        this.possivelCausa = possivelCausa;
        this.descricao = descricao;
        this.nivelDano = nivelDano;
    }
    public abstract String relatorioExtenso();

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPossivelCausa() {
        return possivelCausa;
    }

    public void setPossivelCausa(String possivelCausa) {
        this.possivelCausa = possivelCausa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNivelDano() {
        return nivelDano;
    }

    public void setNivelDano(int nivelDano) {
        this.nivelDano = nivelDano;
    }
}
