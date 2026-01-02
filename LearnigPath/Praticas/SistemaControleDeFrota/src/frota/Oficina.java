package frota;
// * Deve realizar o checkup da situação do carro para locação
// * Deve consertá-lo para as condições mínimas de locação
// * Analisar o estado do carro após a devolução e, se quebrado,
//   calcular a multa com base na gravidade do dano

public abstract class Oficina {
    public String checkup(Veiculo automovel) {
        float tanque = automovel.getTanque();
        float capacidade = automovel.getCapacidadeMaximaTanque();
        String obs = "Observação:";
        String recomendacoes = "\nRecomendações:";
        int testeQualidade = 0;
        if (tanque*100/capacidade < capacidade/3) {
            obs += " tanque abaixo de 1/3 da capacidade";
            recomendacoes += "\n- Abastecer";
            testeQualidade++;
        }

        if (!automovel.isLimpo()) {
            if (testeQualidade > 0) {
                obs += ", sujo";
                recomendacoes += ";\n- Lavar";
            } else {
                obs += " sujo";
                recomendacoes += "\n- Lavar";
            }
            testeQualidade++;
        }

        if (automovel.isQuebrado()) {
            if (testeQualidade > 0) {
                obs += ", quebrado";
                recomendacoes += ";\n- Mandar para concerto";
            } else {
                obs += " quebrado";
                recomendacoes += "\n- Mandar para concerto";
            }
            testeQualidade++;
        }
        String msgBase =  """
                Quilometragem: %.1f
                Tanque: %.2f
                """.formatted(automovel.getQuilometragem(), automovel.getTanquePorcentagem());
        return testeQualidade > 0? msgBase += "Condição de uso: inválido.\n" + obs + recomendacoes + ".": "Condições de uso: Pronto para uso.";

    }
}
