package br.com.autogo.financeiro;

import br.com.autogo.cadastro.Cliente;
import br.com.autogo.frota.VeiculoImpl;

public class Pedido extends Debito {
    private boolean veiculoFoiRetornado;
    public Pedido(Cliente cliente, VeiculoImpl veiculoAlugado, double valor, String descricao) {
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
                        this.getCliente().getNome(),
                        this.getCliente().getCPF(),
                        this.getVeiculoAlugado().getMarca(),
                        this.getVeiculoAlugado().getModelo(),
                        this.getVeiculoAlugado().getPlaca(),
                        this.getDescricao(),
                        this.getValor());
    }
}
