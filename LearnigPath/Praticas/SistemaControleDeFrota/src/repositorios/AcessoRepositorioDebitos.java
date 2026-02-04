package repositorios;

import financeiro.Cliente;
import financeiro.Debitos;
import financeiro.Multa;
import financeiro.Pedido;
import frota.Veiculo;
import oficina.Relatorio;

import java.util.List;

public interface AcessoRepositorioDebitos {
    public abstract void salvarMulta(Relatorio relatorioCondicao, Pedido pedido, double valor);
    public abstract void salvarPedido(Cliente cliente, Veiculo veiculoAlugado, double valor, String descricao);

    public abstract List<Pedido> listarPedidos(boolean pago);
    public abstract Pedido procurarPedido(String placa, boolean pago);
    public abstract Pedido procurarPedido(long CPF, boolean pago);

    public abstract List<Multa> listarMultas(boolean pago);
    public abstract Multa procurarMulta(long CPF, boolean pago);

    public abstract List<Debitos> debitosGeraisCliente(long CPF, boolean pago);
}
