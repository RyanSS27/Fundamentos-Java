package br.com.autogo.repositorio;
import br.com.autogo.cadastro.Cliente;
import java.util.List;

public interface RepositorioCliente {
    String salvarCliente(String nome, long cpf);
    List<Cliente> listarClientes();
    Cliente pesquisarCliente(long cpf);
}
