package frota;

public class CategoriaA extends Veiculo {
    public static int qtdeCategoriaA;
    public CategoriaA(String marca, String modelo, String placa, float quilometragem, float capacidadeMaximaTanque) {
        super(marca, modelo, placa, quilometragem, capacidadeMaximaTanque, "A", 2);
        qtdeCategoriaA++;
    }

    public CategoriaA(String marca, String modelo, float quilometragem, float capacidadeMaximaTanque, int qtdeMaxOcupantes, String placa) {
        super(marca, modelo, placa, quilometragem, capacidadeMaximaTanque, "A", qtdeMaxOcupantes);
        qtdeCategoriaA++;
    }
}
