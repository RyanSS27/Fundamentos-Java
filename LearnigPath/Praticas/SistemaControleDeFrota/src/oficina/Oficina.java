package oficina;
// * Deve realizar o checkup da situação do carro para locação
// * Deve consertá-lo para as condições mínimas de locação nome: preparação

import frota.Veiculo;
import financeiro.Pedido;

import java.util.concurrent.ThreadLocalRandom;

public class Oficina {
    // Deve-se ter 1/3 do tanque para o carro poder ser alugado
    public static final float CAPACIDADE_MINIMA_GASOLINA_LOCACAO = 3.0f;
    private static float reservaGasolina = 10000;

    public static void setReservaGasolina(float litros) {
        reservaGasolina += litros;
    }

    public static float getReservaGasolina() {
        return reservaGasolina;
    }

    // Realiza o checkup da situação do carro para locação
    public static String checkup(Veiculo automovel) {
        /*
            Descrição da função:
            Realiza um checkup minucioso das condições de uso do veículo
            no momento sem as alterar, podendo ser solicitado por
            qualquer requerente do sistema.
        */

        //Verifica se está em condição de uso antes de fazer a busca pela razão
        if (!automovel.isEmCondicaoDeUso()) {
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
                    recomendacoes += "\n- Solicitar o envio do carro ao pátio através da preparação.";
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
    public Relatorio revisaoPosUso(Pedido pedido) {
        /*
            Simula a atuação dos mecânicos, por não haver atores que
            entrem com as condições do veículo e retorna se há algum
            problema ou não e, se sim, retorna a gravidade.
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
            int nivelDano = ThreadLocalRandom.current().nextInt(1, 11);
            pedido.getVeiculoAlugado().setNivelDano(nivelDano);
            String possivelCausa;

            // Simula entrada de descrições dos mecânicos
            String descricao = switch (nivelDano) {
                case 1, 2, 3 -> {
                    possivelCausa = "Uso regular do veículo em vias urbanas.";
                    yield "Danos comuns de desgaste/uso";
                }
                case 4, 5, 6, 7, 8, 9 -> {
                    possivelCausa = "Falta de manutenção preventiva ou condução imprudente.";
                    yield "Danos por má conduta";
                }
                case 10 -> {
                    possivelCausa = "Podemos dizer que ele APARENTEMENTE perdeu a briga com o poste.";
                    yield "PT no carro";
                }
                default -> {
                    possivelCausa = "Nível não identificado.";
                    yield "Valor inválido";
                }
            };
            RelatorioCondicao relatorioCondicao = new RelatorioCondicao(pedido.getVeiculoAlugado().getPlaca(), possivelCausa, descricao, pedido.getVeiculoAlugado().getNivelDano());
            return relatorioCondicao;
        } else {
            pedido.getVeiculoAlugado().setNivelDano(0);
            String descricao = "PT no carro.";
            String possivelCausa = "Podemos dizer que ele APARENTEMENTE perdeu a briga com o poste.";
            return new RelatorioCondicao(pedido.getVeiculoAlugado().getPlaca(), possivelCausa, descricao, pedido.getVeiculoAlugado().getNivelDano());
        }
    }

    // Realiza o conserto do veículo
    public static Relatorio conserto(Veiculo automovel) {
        if (automovel.getNivelDano() == 10) {
            String descricao = "PT no carro.";
            String possivelCausa = "Podemos dizer que ele APARENTEMENTE perdeu a briga com o poste.";
            return new RelatorioCondicao(automovel.getPlaca(), possivelCausa, descricao, automovel.getNivelDano());
        } else if (automovel.getNivelDano() == 0) {
            return new RelatorioCondicao(automovel.getPlaca(), "Veículo em ótimo estado", "Sem erros encontrados.", automovel.getNivelDano());
        } else {
            int nivelDano = automovel.getNivelDano();
            // Simula um custo por manutenção
            float valorMin = nivelDano * 100;
            float valorMax = nivelDano * 1500;
            float custo = ThreadLocalRandom.current().nextFloat(valorMin, valorMax);

            // Simula a entrada dos mecânicos
            String possivelCausa = nivelDano <= 3? "Veículo tava cansado chefia, defeito de uso." : "Tirem a CNH dessa pessoa, não há veículo que aguente esse barbeiro.";
            String descricaoConserto = "Trocamos a rebimboca da parafuseta e os tubos metálicos de serpentina. A parada ficou sinistra.";
            automovel.setEmManutencao(true);
            automovel.serConsertado();

            return new RelatorioConserto(automovel.getPlaca(), custo, possivelCausa, descricaoConserto, nivelDano);
        }
    }

    // Realiza a preparação completa do veículo para locação
    public static String preparacao(Veiculo automovel) {
        if (automovel.getNivelDano() == 10) {
            return """
                    ===========================================================
                                  RELATÓRIO DE CONDIÇÃO DE USO
                    ===========================================================
                    Carro inutilizável.
                    Razão: Perda total.
                    """;
        }
        automovel.setEmManutencao(!automovel.isEmManutencao());
        String relatorioFinal = abastecer(automovel, "min");
        Relatorio relatorioConcerto = conserto(automovel);
        relatorioFinal += "\n" + relatorioConcerto.relatorioExtenso();
        automovel.lavar();
        automovel.setEmCondicaoDeUso();
        // Tira o carro ou não da manutenção
        automovel.setEmManutencao(!automovel.isEmManutencao());
        String notaDeCondicao = automovel.isEmCondicaoDeUso()?
                "Inápto no momento." : "Veículo nos trinques chefia, pronto para locação.";
        return """
                ===========================================================
                              RELATÓRIO DE CONDIÇÃO DE USO
                ===========================================================
                Condição: %s
                Relatório:
                %s
                
                Obs: contate a oficina para mais detalhes do carro.
                """.formatted(notaDeCondicao, relatorioFinal);
    }

    // Abastece conforme a quantidade desejada de litros
    public static String abastecer(Veiculo automovel, float litrosDesejados) {
        if (reservaGasolina <= 0) {
            return "Erro: Reserva da oficina vazia.";
        }

        // Verifica o que a oficina pode fornecer
        float disponivelParaUso = Math.min(litrosDesejados, reservaGasolina);

        // O veículo processa quanto desses litros cabem no tanque
        float litrosAbastecidos = automovel.abastecer(disponivelParaUso);

        // Deduz da reserva apenas o que saiu para o tanque
        reservaGasolina -= litrosAbastecidos;

        // O excedente é a diferença entre o que o usuário queria e o que coube/tinha
        float testeAbastecimento = litrosDesejados - litrosAbastecidos;
        String notaControle;

        /*
            Ou o carro abasteceu conforme o desejado ou ele abasteceu menos,
            já que não pode ter abastecido mais que o desejado.
         */
        if (testeAbastecimento == 0) {
            notaControle =  "A quantidade desejada foi abastecida.";
        } else {
            /*
                Se os litrosAbastecidos foram menores que a qtde desejada
                (testeAbastecimento > 0) pode-se ter ocorrido 2 coisas:
                1° Oficina não ter gasolina suficiente
                2° O carro não suportar tantos litros em sua capacidade,
                abastecendo somente o necessário para encher o tanque
             */
            notaControle = "Foram abastecidos menos litros que o desejado ";
            if(automovel.getTanquePorcentagem() == 100) {
                notaControle += "pois excedia a capacidade máxima do tanque.";
            } else {
                notaControle += "pois não há combustível suficiente na reserva da oficina.";
            }
        }

        return gerarRelatorio(litrosAbastecidos, notaControle, automovel.getTanquePorcentagem());
    }

    // Enche o tanque ou preenche o mínimo de combustível para locação
    public static String abastecer(Veiculo automovel, String minOuMax) {
        if ("min".equalsIgnoreCase(minOuMax)) {
            float nivelMinimo = automovel.getCapacidadeMaximaTanque() / 3.0f;

            if (automovel.getTanque() >= nivelMinimo) {
                return "Nada a fazer: Veículo já possui combustível suficiente.";
            }

            float necessarioParaCompletar = nivelMinimo - automovel.getTanque();
            return abastecer(automovel, necessarioParaCompletar);
        }

        if ("max".equalsIgnoreCase(minOuMax)) {
            float necessidadeTotal = automovel.getCapacidadeMaximaTanque() - automovel.getTanque();
            return abastecer(automovel, necessidadeTotal);
        }

        return "Erro: Opção '" + minOuMax + "' inválida. Use 'min' ou 'max'.";
    }

    // Relatorio de abastecimento
    private static String gerarRelatorio(float abastecido, String notaControle, float porcentagem) {
        return """
                ===========================================================
                                  RELATÓRIO ABASTECIMENTO
                ===========================================================
                Foram abastecidos: %.1fl
                Nota de controle: %s
                Estado do tanque: %.1f%%
            
                """.formatted(abastecido, notaControle, porcentagem);
    }
}
