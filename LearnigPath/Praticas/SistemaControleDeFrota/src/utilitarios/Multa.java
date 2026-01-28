package utilitarios;

import oficina.Relatorio;
import oficina.RelatorioCondicao;

public class Multa extends Debitos {
    public static final int TAXA_PERDA_PATRIMONIO = 15;

    public Multa(RelatorioCondicao relatorioCondicao, Pedido pedido) {
        if (relatorioCondicao.getNivelDano() > 3 && relatorioCondicao.getNivelDano() < 10) {

            // A cada nível de dano, 5% a mais do veículo é cobrado
            // Exemplo: Nível 4 = 20%, Nível 9 = 45%
            float percentualDano = relatorioCondicao.getNivelDano() * 0.05f;
            float valor = percentualDano * pedido.veiculoAlugado.getValor();
            super(pedido.getCliente(), pedido.getVeiculoAlugado(), valor, relatorioCondicao.getDescricao());
        }
    }


    // Falta tratar os danos arcados pela empresa
    // e os danos por má conduta
    public static String calcMultaMaConduta(Relatorio relatorioCondicao, Pedido pedido) {

    }
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
