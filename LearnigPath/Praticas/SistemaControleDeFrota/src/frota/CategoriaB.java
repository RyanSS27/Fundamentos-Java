package frota;

public class CategoriaB extends Veiculo {
    //verificar se está correta a ocultação
    private final float taxaDesvalorizacao = 20f;

    public static int qtdeCategoriaB;
    public CategoriaB(String marca, String modelo, float quilometragem, float capacidadeMaximaTanque) {
        super(marca, modelo, quilometragem, capacidadeMaximaTanque, "B", 4);
        qtdeCategoriaB++;
        this.setCategoria("B");
        this.setQtdeMaxOcupantes(4);
    }

    public CategoriaB(String marca, String modelo, float quilometragem, float capacidadeMaximaTanque, int qtdeMaximaOcupantes) {
        super(marca, modelo, quilometragem, capacidadeMaximaTanque, "B", qtdeMaximaOcupantes);
        qtdeCategoriaB++;
    }
}
