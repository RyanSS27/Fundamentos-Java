package frota;

public abstract class Oficina {
    public String checkup(Veiculo automovel) {
        float tanque = automovel.tanque;
        float capacidade = automovel.capacidadeMaximaTanque;
        String obs = "Observação:";
        String recomendacoes = "\nRecomendações:";
        int testeQualidade = 0;
        if (tanque*100/capacidade < capacidade/3) {
            obs += "tanque abaixo de 1/3 da capacidade";
            recomendacoes += "\n- Abastecer";
            testeQualidade++;
        }

        if (!automovel.limpo) {
            if (testeQualidade > 0) {
                obs += ", sujo";
                recomendacoes += ";\n- Lavar";
            } else {
                obs += " sujo";
                recomendacoes += "\n- Lavar";
            }
            testeQualidade++;
        }

        if (automovel.quebrado) {
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
                """.formatted(automovel.quilometragem, automovel.tanque);
        return testeQualidade > 0? msgBase += "Condição de uso: inválido.\n" + obs + recomendacoes + ".": "Condições de uso: Pronto para uso.";

    }
}
