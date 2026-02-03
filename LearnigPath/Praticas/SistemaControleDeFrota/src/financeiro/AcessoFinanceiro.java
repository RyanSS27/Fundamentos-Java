package financeiro;

public interface AcessoFinanceiro {
    public abstract boolean isFinanceiramenteElegivel(long CPF);
    // A função deve receber a lista de pendências filtradas pelo CPF
    // do cliente, através do método debitosGeraisCliente(long CPF)
    public abstract double pagarPendencias(double CPF);
    public abstract String pagarMultas(double pagamento, Multa multa);
    public abstract String pagarPedidos(double pagamento, Pedido pedido);
}
