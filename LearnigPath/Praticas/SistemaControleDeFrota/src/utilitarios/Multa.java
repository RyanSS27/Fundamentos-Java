package utilitarios;

public class Multa {
    public static final int TAXA_PERDA_PATRIMONIO = 15;

    // Falta tratar os danos arcados pela empresa
    // e os danos por má conduta
    // Multa de perda total do veículo
    public static String calcMulta(float valorVeiculoDesvalorizado) {
        return """
                =======================
                    MULTA APLICÁVEL
                =======================
                Valor final: R$%.2f
                """.formatted(valorVeiculoDesvalorizado * (1 + (TAXA_PERDA_PATRIMONIO / 100.0f)));
    }
}
