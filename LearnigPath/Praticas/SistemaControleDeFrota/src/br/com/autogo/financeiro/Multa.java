package br.com.autogo.financeiro;

import br.com.autogo.oficina.Relatorio;

public class Multa extends Debito {
    public static final int TAXA_PERDA_PATRIMONIO = 15;
    // Serve para salvar o nível de dano que o carro tinha no momento,
    // pois, como a referência sempre apontará para o objeto ele pode
    // ser consertado e perderá o estado que queremos referênciar
    private int nivelDano;

    public Multa(Relatorio relatorioCondicao, Pedido pedido, double valor) {
        super(pedido.getCliente(), pedido.getVeiculoAlugado(), valor, relatorioCondicao.getDescricao());
        setNivelDano(pedido.getVeiculoAlugado().getNivelDano());
    }

    @Override
    public String toString() {
        return """
                ---------------------
                       MULTA
                ---------------------
                Cliente: %s
                CPF: %d
                ----- Automóvel -----
                %s - %s
                Placa: %s
                Nível de dano: %d
                Descrição: %s
                ---------------------
                Valor: R$%.2f
                ---------------------
                """.formatted(
                this.getCliente().getNome(),
                this.getCliente().getCPF(),
                this.getVeiculoAlugado().getMarca(),
                this.getVeiculoAlugado().getModelo(),
                this.getVeiculoAlugado().getPlaca(),
                getNivelDano(),
                getDescricao(),
                getValor());
    }

    public int getNivelDano() {
        return nivelDano;
    }

    public void setNivelDano(int nivelDano) {
        this.nivelDano = nivelDano;
    }
}
