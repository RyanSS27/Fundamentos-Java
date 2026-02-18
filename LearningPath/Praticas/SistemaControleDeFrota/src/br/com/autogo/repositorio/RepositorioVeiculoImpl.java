package br.com.autogo.repositorio;

import br.com.autogo.frota.VeiculoImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioVeiculoImpl implements RepositorioVeiculo {
    private List<VeiculoImpl> frota = new ArrayList<>();

    @Override
    public int tamanhoFrota() {
        return frota.size();
    }

    @Override
    public long contarPorCategoria(String categoria) {
        return frota.stream()
                .filter(v -> v.getCategoria().equalsIgnoreCase(categoria))
                .count();
    }

    @Override
    public void salvarVeiculo(String marca, String modelo, String placa, float quilometragem, float capacidadeMaximaTanque, String categoria, int qtdeMaxOcupantes, float valor) {
        frota.add(new VeiculoImpl(marca, modelo, placa, quilometragem, capacidadeMaximaTanque, categoria, qtdeMaxOcupantes, valor));
        frota.sort(Comparator.comparing(VeiculoImpl::getCategoria));
    }

    @Override
    public List<VeiculoImpl> listarVeiculos() {
        return new ArrayList<>(frota);
    }

    @Override
    public List<VeiculoImpl> listarVeiculos(String categoria) {
        return new ArrayList<>(frota.stream().filter(x -> x.getCategoria().equals(categoria)).collect(Collectors.toList()));
    }

    @Override
    public List<VeiculoImpl> listarVeiculos(String categoria, boolean emCondicaoDeUso) {
        return frota.stream()
                .filter(x -> x.isEmCondicaoDeUso() == emCondicaoDeUso)
                .filter(x -> x.getCategoria().equalsIgnoreCase(categoria))
                .toList();
    }
}
