package frota;
// * Deve realizar o checkup da situação do carro para locação
// * Deve consertá-lo para as condições mínimas de locação nome: preparação

import java.util.concurrent.ThreadLocalRandom;

public abstract class Oficina {
    private static int reservaGasolina;

    // Realiza o checkup da situação do carro para locação
    public static String checkup(Veiculo automovel) {
        /*
            Descrição da função:
            Realiza um checkup minucioso das condições de uso do veículo
            no momento sem as alterar, podendo ser solicitado por
            qualquer requerente do sistema.
        */

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
            // Se estiver em condições, retorna a mensagem
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

    // Analisa o veículo após o uso do cliente
    public int revisaoPosUso(Veiculo automovel) {
        /*
            Simula a atuação dos mecânicos, por não haver atores que
            entrem com as condições do veículo e calcula os custos
            de manutenção e multa para o cliente conforme a
            gravidade do problema.
         */

        // Chance de 1/4 de estar quebrado
        int chanceQuebra = ThreadLocalRandom.current().nextInt(1, 5);
        /*
            0 = não há danos
            1-3 (3/10) = danos comuns de desgaste/uso
            4-9 (6/10) = danos por má conduta
            10 (1/10) = pt no carro
        */
        if (chanceQuebra == 1) {
            int nivelDano = ThreadLocalRandom.current().nextInt();
            automovel.setNivelDano(nivelDano);
            return nivelDano;
        } else {
            automovel.setNivelDano(0);
            return 0;
        }
    }

    // Realiza o conserto do veículo
    public void concerto(Veiculo automovel) {

    }

    // Realiza a preparação completa do veículo para locação
    public void preparacao(Veiculo automovel) {
        
    }
}
