package repositorios;

import financeiro.Cliente;

import java.util.ArrayList;
import java.util.List;

public class RespositorioClientes implements AcessoRepositorioClientes {
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public String salvarCliente(String nome, long cpf) {
        Cliente testeDuplicidade = pesquisarCliente(cpf);
        if (testeDuplicidade == null) {
            clientes.add(new Cliente(nome, cpf));
            return "Cliente cadastrado com sucesso!";
        } else {
            return "Cliente já possui cadastro: " + testeDuplicidade.toString();
        }
    }

    @Override
    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes);
    }

    @Override
    public Cliente pesquisarCliente(long cpf) {
        Cliente cliente = clientes.stream().filter(x -> x.getCPF() == cpf).findFirst().orElse(null);
        return cliente;
    }
}
