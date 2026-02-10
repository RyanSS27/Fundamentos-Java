package br.com.autogo.financeiro;

import br.com.autogo.oficina.Relatorio;

public interface ServicoFinanceiro {
    boolean isFinanceiramenteElegivel(long cpf);
    double calcularDebitos(long cpf);
    /*
        A função deve receber a lista de pendências filtradas pelo CPF
        do cliente, através do método debitosGeraisCliente(long CPF)
    */
    String pagarPendencias(long cpf, double pagamento);
    Double calcMulta(Relatorio relatorio, Pedido pedido);
    String pagarMultas(double pagamento, Multa multa);
    String pagarPedidos(double pagamento, Pedido pedido);
}
