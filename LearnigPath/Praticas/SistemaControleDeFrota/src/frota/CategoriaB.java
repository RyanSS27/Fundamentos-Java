package frota;

public class CategoriaB extends Veiculo {
    public static int qtdeCategoriaB;
    public CategoriaB(String marca, String modelo, float quilometragem, float capacidadeMaximaTanque) {
        super(marca, modelo, quilometragem, capacidadeMaximaTanque, "B", 4);
        qtdeCategoriaB++;
        this.categoria = "B";
        qtdeMaxOcupantes = 4;
    }

    public CategoriaB(String marca, String modelo, float quilometragem, float capacidadeMaximaTanque, int qtdeMaximaOcupantes) {
        super(marca, modelo, quilometragem, capacidadeMaximaTanque, "B", qtdeMaximaOcupantes);
        qtdeCategoriaB++;
    }
}
