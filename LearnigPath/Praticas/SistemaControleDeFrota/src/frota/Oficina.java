package frota;
// * Deve realizar o checkup da situação do carro para locação
// * Deve consertá-lo para as condições mínimas de locação nome: preparação
// * Analisar o estado do carro após a devolução e, se quebrado,
//   calcular a multa com base na gravidade do dano

public abstract class Oficina {
    // CHECKUP NÃO TERMINADO
    public static String checkup(Veiculo automovel) {
        //Verifica se está em condição de uso antes de fazer a busca pela razão
        if (automovel.isEmCondicaoDeUso()) {
            int testeQualidade = 0;
            float tanque = automovel.getTanque();
            float capacidade = automovel.getCapacidadeMaximaTanque();
            String obs = "Observação:";
            String recomendacoes = "\nRecomendações:";

            //Testa se o tanque está com o mínimo indicado para locação
            if (tanque*100/capacidade <= capacidade/3) {
                obs += " tanque abaixo de 1/3 da capacidade";
                recomendacoes += "\n- Abastecer";
                testeQualidade++;
            }

            //Testa se está limpo
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

            //Testa se está quebrado
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

            //Testa se continua em manutenção
            if (automovel.isEmManutencao()) {
                if (testeQualidade > 0) {
                    obs += ", está na oficina";
                    recomendacoes += ";\n- Espere o termino da manutenção para solicitar o envio do carro ao pátio";
                } else {
                    obs += " está na oficina";
                    recomendacoes += "\n- Solicitar o envio do carro ao pátio";
                }
            }

            String msgBase =  """
                ===========================================================
                              RELATÓRIO DE CONDIÇÃO DO VEÍCULO
                ===========================================================
                Condição de uso: inválido.
                Quilometragem: %.1f
                Tanque: %.2f
                """.formatted(automovel.getQuilometragem(), automovel.getTanquePorcentagem());
            return msgBase += obs + recomendacoes;
        } else {
            return """
                    ===========================================================
                                  RELATÓRIO DE CONDIÇÃO DO VEÍCULO
                    ===========================================================
                    Condição de uso: Válida.
                    Quilometragem: %.1f
                    Tanque: %.2f
                    Veículo está limpo, tanque em condições e já está no pátio.
                """.formatted(automovel.getQuilometragem(), automovel.getTanquePorcentagem());
        }
    }

    public void preparacao(Veiculo automovel) {
        
    }
}
