package br.com.autogo.repositorio;

import br.com.autogo.frota.VeiculoImpl;

import java.util.List;

public interface RepositorioVeiculo {
    int tamanhoFrota();
    long contarPorCategoria(String categoria);
    void salvarVeiculo(String marca, String modelo, String placa, float quilometragem, float capacidadeMaximaTanque, String categoria, int qtdeMaxOcupantes, float valor);
    // Deve retornar um array com os veículos desejados

    List<VeiculoImpl> listarVeiculos();
    List<VeiculoImpl> listarVeiculos(String categoria);
    List<VeiculoImpl> listarVeiculos(String categoria, boolean emCondicaoUso);
}
