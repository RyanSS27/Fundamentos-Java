package utilitarios;

import oficina.Relatorio;
import oficina.RelatorioCondicao;

public class Multa extends Debitos {
    public static final int TAXA_PERDA_PATRIMONIO = 15;
    // Serve para salvar o nível de dano que o carro tinha no momento,
    // pois, como a referência sempre apontará para o objeto ele pode
    // ser consertado e perderá o estado que queremos referênciar
    private int nivelDano;

    public Multa(Relatorio relatorioCondicao, Pedido pedido, double valor) {
        super(pedido.getCliente(), pedido.getVeiculoAlugado(), valor, relatorioCondicao.getDescricao());
        setNivelDano(pedido.getVeiculoAlugado().getNivelDano());
    }

    public static Multa calcMulta(Relatorio relatorioCondicao, Pedido pedido) {
        // Se o dano for < 3, a cobrança não é atribuída ao cliente
        if (relatorioCondicao.getNivelDano() > 3 && relatorioCondicao.getNivelDano() < 10) {
            // A cada nível de dano, 5% a mais do veículo é cobrado
            // Exemplo: Nível 4 = 20%, Nível 9 = 45%
            float percentualDano = relatorioCondicao.getNivelDano() * 0.05f;
            double valor = percentualDano * pedido.veiculoAlugado.getValor();
            return new Multa(relatorioCondicao, pedido, valor);
        } else {
            return null;
        }
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
                this.cliente.getNome(),
                this.cliente.getCPF(),
                this.veiculoAlugado.getMarca(),
                this.veiculoAlugado.getModelo(),
                this.veiculoAlugado.getPlaca(),
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
