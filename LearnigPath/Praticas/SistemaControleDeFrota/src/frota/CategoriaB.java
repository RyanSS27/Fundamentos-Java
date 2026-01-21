package frota;

public class CategoriaB extends Veiculo {
    //verificar se está correta a ocultação
    private final float taxaDesvalorizacao = 20f;

    public static int qtdeCategoriaB;
    public CategoriaB(String marca, String modelo, String placa, float quilometragem, float capacidadeMaximaTanque) {
        super(marca, modelo, placa, quilometragem, capacidadeMaximaTanque, "B", 4);
        qtdeCategoriaB++;
    }

    public CategoriaB(String marca, String modelo, String placa, float quilometragem, float capacidadeMaximaTanque, int qtdeMaximaOcupantes) {
        super(marca, modelo, placa, quilometragem, capacidadeMaximaTanque, "B", qtdeMaximaOcupantes);
        qtdeCategoriaB++;
    }
}
