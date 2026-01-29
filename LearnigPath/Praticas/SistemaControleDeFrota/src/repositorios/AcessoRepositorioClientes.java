package repositorios;
import utilitarios.Cliente;
import java.util.List;

public interface AcessoRepositorioClientes {
    public abstract void salvarCliente(long CPF);
    public abstract List<Cliente> listarClientes();
    public abstract Cliente pesquisarCliente(long CPF);
}
