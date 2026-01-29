package repositorios;

import utilitarios.Debitos;
import utilitarios.Multa;
import utilitarios.Pedido;

import java.util.List;

public interface AcessoRepositorioDebitos {
    public abstract void salvarDebitos(Multa multa);
    public abstract void salvarDebitos(Pedido pedido);

    public abstract List<Pedido> listarPedidos(boolean pago);
    public abstract Pedido procurarPedido(String placa, boolean pago);
    public abstract Pedido procurarPedido(long CPF, boolean pago);

    public abstract List<Multa> listarMultas(boolean pago);
    public abstract Multa procurarMulta(long CPF, boolean pago);

}
