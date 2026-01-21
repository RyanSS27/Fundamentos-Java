package frota;

public class CategoriaC extends Veiculo {
    public static int qtdeCategoriaC;
    public CategoriaC(String marca, String modelo, String placa, float quilometragem, float capacidadeMaximaTanque) {
        super(marca, modelo, placa, quilometragem, capacidadeMaximaTanque, "C", 4);
        qtdeCategoriaC++;
    }

    public CategoriaC(String marca, String modelo, String placa, float quilometragem, float capacidadeMaximaTanque, int qtdeMaximaOcupantes) {
        super(marca, modelo, placa, quilometragem, capacidadeMaximaTanque, "C", qtdeMaximaOcupantes);
        qtdeCategoriaC++;
    }
}
