package br.com.autogo.repositorio;

import br.com.autogo.cadastro.Cliente;
import br.com.autogo.financeiro.Debito;
import br.com.autogo.financeiro.Multa;
import br.com.autogo.financeiro.Pedido;
import br.com.autogo.frota.VeiculoImpl;
import br.com.autogo.oficina.Relatorio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RepositorioDebitoImpl implements RepositorioDebito {
    private static List<Multa> multas = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();


    @Override
    public void salvarMulta(Relatorio relatorioCondicao, Pedido pedido, double valor) {
        multas.add(new Multa(relatorioCondicao, pedido, valor));
    }

    @Override
    public void salvarPedido(Cliente cliente, VeiculoImpl veiculoAlugado, double valor, String descricao) {
        pedidos.add(new Pedido(cliente, veiculoAlugado, valor, descricao));
    }

    @Override
    public List<Debito> listarPedidos(boolean pago) {
        return new ArrayList<>(pedidos.stream().filter(x -> x.isPaga() == pago).collect(Collectors.toList()));
    }

    @Override
    public Pedido procurarPedido(String placa, boolean pago) {
        return pedidos.stream().filter(
                x -> x.getVeiculoAlugado().getPlaca().equals(placa) && x.isPaga() == pago)
                .findFirst().orElse(null);
    }

    @Override
    public Pedido procurarPedido(long CPF, boolean pago) {
        return pedidos.stream().filter(
                        x -> x.getCliente().getCPF() == CPF && x.isPaga() == pago)
                        .findFirst().orElse(null);
    }

    @Override
    public List<Multa> listarMultas(boolean pago) {
        return new ArrayList<>(multas.stream().filter(x -> x.isPaga() == pago).collect(Collectors.toList()));
    }

    @Override
    public Multa procurarMulta(long CPF, boolean pago) {
         return multas.stream().filter(
                        x -> x.getCliente().getCPF() == CPF && x.isPaga() == pago)
                        .findFirst().orElse(null);
    }

    @Override
    public List<Debito> debitosGeraisCliente(long cpf, boolean pago) {
        List<Debito> debitosGerais = Stream.concat(multas.stream(), pedidos.stream())
                .filter(x -> x.getCliente().getCPF() == cpf && x.isPaga() == pago)
                .toList();
        // toList Faz com que a lista seja imutável
        // se adicionar um new ArrayList(debitosGerais), a lista se torna mutável
        return debitosGerais;
    }
}