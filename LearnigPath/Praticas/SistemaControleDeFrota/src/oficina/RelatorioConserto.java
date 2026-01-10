package oficina;

public class RelatorioConserto extends Relatorio {
    private float custoReparo;

    public RelatorioConserto(String placa, float custoReparo, String possivelCausa, String descricao, int nivelDano) {
        super(placa, possivelCausa, descricao, nivelDano);
        this.custoReparo = custoReparo;
    }

    public String relatorioExtenso() {
        return """
                -----------------------------
                      Láudo da officina
                -----------------------------
                Veículo placa: %s
                Nível dano: %d
                Custo do reparo: %f
                Descrição: 
                %s
                Possível causa: 
                %s
                """.formatted(getPlaca(), getNivelDano(), getCustoReparo(), getDescricao(), getPossivelCausa());
    }

    public float getCustoReparo() {
        return custoReparo;
    }

    public void setCustoReparo(float custoReparo) {
        this.custoReparo = custoReparo;
    }
}
