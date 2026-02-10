package br.com.autogo.repositorio;

import br.com.autogo.cadastro.Cliente;
import br.com.autogo.financeiro.Debito;
import br.com.autogo.financeiro.Multa;
import br.com.autogo.financeiro.Pedido;
import br.com.autogo.frota.VeiculoImpl;
import br.com.autogo.oficina.Relatorio;

import java.util.List;

public interface RepositorioDebito {
    void salvarMulta(Relatorio relatorioCondicao, Pedido pedido, double valor);
    void salvarPedido(Cliente cliente, VeiculoImpl veiculoAlugado, double valor, String descricao);

    List<Debito> listarPedidos(boolean pago);
    Pedido procurarPedido(String placa, boolean pago);
    Pedido procurarPedido(long CPF, boolean pago);

    List<Multa> listarMultas(boolean pago);
    Multa procurarMulta(long CPF, boolean pago);

    List<Debito> debitosGeraisCliente(long CPF, boolean pago);
}
