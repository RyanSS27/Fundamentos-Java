package repositorios;

import financeiro.Cliente;

import java.util.ArrayList;
import java.util.List;

public class RespositorioClientes implements AcessoRepositorioClientes {
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public void salvarCliente(String nome, long CPF) {
        Cliente testeDuplicidade = clientes.stream().filter(x -> x.getCPF() == CPF).findFirst().orElse(null);
        if (testeDuplicidade == null) {
            clientes.add(new Cliente(nome, CPF));
        }
    }

    @Override
    public List<Cliente> listarClientes() {
        return List.of();
    }

    @Override
    public Cliente pesquisarCliente(long CPF) {
        return null;
    }
}
