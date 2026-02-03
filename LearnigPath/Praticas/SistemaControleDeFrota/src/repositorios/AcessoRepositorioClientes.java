package repositorios;
import financeiro.Cliente;
import java.util.List;

public interface AcessoRepositorioClientes {
    public abstract void salvarCliente(String nome, long CPF);
    public abstract List<Cliente> listarClientes();
    public abstract Cliente pesquisarCliente(long CPF);
}
