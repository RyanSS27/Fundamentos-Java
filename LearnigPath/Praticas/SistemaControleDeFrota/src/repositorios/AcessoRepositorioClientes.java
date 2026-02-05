package repositorios;
import financeiro.Cliente;
import java.util.List;

public interface AcessoRepositorioClientes {
    public abstract String salvarCliente(String nome, long cpf);
    public abstract List<Cliente> listarClientes();
    public abstract Cliente pesquisarCliente(long cpf);
}
