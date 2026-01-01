package frota;

public class CategoriaA extends Veiculo {
    public static int qtdeCategoriaA;
    public CategoriaA(String marca, String modelo, float quilometragem, float capacidadeMaximaTanque) {
        super(marca, modelo, quilometragem, capacidadeMaximaTanque, "A", 2);
        qtdeCategoriaA++;
    }

    public CategoriaA(String marca, String modelo, float quilometragem, float capacidadeMaximaTanque, int qtdeMaxOcupantes) {
        super(marca, modelo, quilometragem, capacidadeMaximaTanque, "A", qtdeMaxOcupantes);
        qtdeCategoriaA++;
    }
}
