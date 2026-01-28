package utilitarios;

import frota.Veiculo;

public class Pedido extends Debitos {
    public Pedido(Cliente cliente, Veiculo veiculoAlugado, float valor, String descricao) {
        super(cliente, veiculoAlugado, valor, descricao);
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
