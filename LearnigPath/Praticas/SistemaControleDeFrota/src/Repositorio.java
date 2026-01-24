import frota.Veiculo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Repositorio implements AcessoRepositorio {
    private List<Veiculo> frota = new ArrayList<>();

    @Override
    public void salvarVeiculo(String marca, String modelo, String placa, float quilometragem, float capacidadeMaximaTanque, String categoria, int qtdeMaxOcupantes) {
        frota.add(new Veiculo(marca, modelo, placa, quilometragem, capacidadeMaximaTanque, categoria, qtdeMaxOcupantes));
        frota.sort(Comparator.comparing(Veiculo::getCategoria));
    }

    @Override
    public List<Veiculo> listarVeiculos() {
        return new ArrayList<>(frota);
    }

    @Override
    public List<Veiculo> listarVeiculos(String categoria) {
        return new ArrayList<>(frota.stream().filter(x -> x.getCategoria().equals(categoria)).collect(Collectors.toList()));
    }

    @Override
    public List<Veiculo> listarVeiculos(String categoria, boolean emUso) {
        return List.of();
    }
}
