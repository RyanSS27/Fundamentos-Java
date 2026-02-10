package br.com.autogo.oficina;

public class RelatorioCondicao extends Relatorio {
    public RelatorioCondicao(String placa, String possivelCausa, String descricao, int nivelDano) {
        super(placa, possivelCausa, descricao, nivelDano);
    }

    @Override
    public String relatorioExtenso() {
        return """
                -----------------------------
                      Láudo da officina
                -----------------------------
                Veículo placa: %s
                Nível dano: %d
                Descrição:
                %s
                Possível causa:
                %s
                """.formatted(getPlaca(), getNivelDano(), getDescricao(), getPossivelCausa());
    }
}
