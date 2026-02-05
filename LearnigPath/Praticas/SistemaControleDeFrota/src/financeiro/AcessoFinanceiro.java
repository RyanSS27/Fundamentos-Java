package financeiro;

public interface AcessoFinanceiro {
    public abstract boolean isFinanceiramenteElegivel(long cpf);
    public abstract double calcularDebitos(long cpf);
    /*
        A função deve receber a lista de pendências filtradas pelo CPF
        do cliente, através do método debitosGeraisCliente(long CPF)
    */
    public abstract String pagarPendencias(long cpf, double pagamento);
    public abstract String pagarMultas(double pagamento, Multa multa);
    public abstract String pagarPedidos(double pagamento, Pedido pedido);
}
