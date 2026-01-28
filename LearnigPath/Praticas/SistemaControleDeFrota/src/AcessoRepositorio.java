import frota.Veiculo;

import java.util.List;

public interface AcessoRepositorio {
    public abstract void salvarVeiculo(String marca, String modelo, String placa, float quilometragem, float capacidadeMaximaTanque, String categoria, int qtdeMaxOcupantes, float valor);
    // Deve retornar um array com os veículos desejados

    public abstract List<Veiculo> listarVeiculos();
    public abstract List<Veiculo> listarVeiculos(String categoria);
    public abstract List<Veiculo> listarVeiculos(String categoria, boolean emCondicaoUso);
}
