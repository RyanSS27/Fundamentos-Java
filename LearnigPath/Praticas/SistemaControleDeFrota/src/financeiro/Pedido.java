package financeiro;

import frota.Veiculo;

public class Pedido extends Debitos {
    private boolean veiculoFoiRetornado;
    public Pedido(Cliente cliente, Veiculo veiculoAlugado, double valor, String descricao) {
        super(cliente, veiculoAlugado, valor, descricao);
        setVeiculoFoiRetornado(false);
    }

    public boolean isVeiculoFoiRetornado() {
        return veiculoFoiRetornado;
    }

    public void setVeiculoFoiRetornado(boolean veiculoFoiRetornado) {
        this.veiculoFoiRetornado = veiculoFoiRetornado;
    }

    @Override
    public String toString() {
        return """
                ---------------------
                       PEDIDO
                ---------------------
                Nome: %s
                CPF: %d
                ----- Automóvel -----
                %s - %s
                Placa: %s
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
                        this.descricao,
                        this.valor);
    }
}
