package frota;

public abstract class Veiculo {
    private static int qtdeVeiculos;

    // Atributos
    protected String marca;
    protected String modelo;
    protected String categoria;
    /*
    A: Duas ou três rodas (motos, motonetas, triciclos).
    B: Veículos de passeio, SUVs, picapes, vans leves (até 3.500kg e 8 lugares).
    C: Caminhões e vans de carga (entre 3.500kg e 6.000kg).
     */
    protected final int LIMITADOR_VELOCIDADE = 110;
    protected int qtdeMaxOcupantes;
    protected float capacidadeMaximaTanque;

    // Atributos de estado
    protected float tanque; // litros vigentes
    protected boolean emManutencao;
    protected boolean limpo;
    protected boolean emCondicaoDeUso;
    protected float quilometragem;

    public Veiculo(String marca, String modelo, float quilometragem, float capacidadeMaximaTanque, String categoria, int qtdeMaxOcupantes) {
        qtdeVeiculos++;
        this.modelo = modelo;
        this.marca = marca;
        this.categoria = categoria;
        this.qtdeMaxOcupantes = qtdeMaxOcupantes;
        this.capacidadeMaximaTanque = capacidadeMaximaTanque;
        this.quilometragem = quilometragem;
    }

    private void novoVeiculo() {
        qtdeVeiculos++;
    }

    protected void rodar(float quilometros) {
        limpo = false;
        emCondicaoDeUso = false;
        quilometragem =+ quilometros;
    }

    protected String abastecer(float litros) {
        if (tanque + litros > 10) {
            float excedente = (tanque + litros) - capacidadeMaximaTanque;
            tanque = capacidadeMaximaTanque;
            return """
                    ===========================================================
                                      RELATÓRIO ABASTECIMENTO
                    ===========================================================
                    A quantidade desejada excede a capacidade máxima do tanque.
                    Foram abastecidos: %.1fl
                    Excedente: %.1fl
                    Estado do tanque: 100%%
                    
                    """.formatted((litros - excedente), excedente);
        } else {
            tanque =+ litros;
            return """
                    ===========================================================
                                      RELATÓRIO ABASTECIMENTO
                    ===========================================================
                    A quantidade desejada excede a capacidade máxima do tanque.
                    Foram abastecidos: %.1fl
                    Estado do tanque: %.1f%%
                    """.formatted(litros, (tanque*100/capacidadeMaximaTanque));
        }
    }
}
