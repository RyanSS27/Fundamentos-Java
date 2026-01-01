package frota;

public class CategoriaC extends Veiculo {
    public static int qtdeCategoriaC;
    public CategoriaC(String marca, String modelo, float quilometragem, float capacidadeMaximaTanque) {
        super(marca, modelo, quilometragem, capacidadeMaximaTanque, "B", 4);
        qtdeCategoriaC++;
        this.categoria = "C";
        qtdeMaxOcupantes = 2;
    }

    public CategoriaC(String marca, String modelo, float quilometragem, float capacidadeMaximaTanque, int qtdeMaximaOcupantes) {
        super(marca, modelo, quilometragem, capacidadeMaximaTanque, "B", qtdeMaximaOcupantes);
        qtdeCategoriaC++;
    }
}
