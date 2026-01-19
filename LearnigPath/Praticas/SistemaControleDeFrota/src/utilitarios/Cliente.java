package utilitarios;

import frota.Veiculo;

// deve receber também multas de trânsito e multa por ferrar com o carro ao fechar a conta
public class Cliente {
    private String nome;
    private int CPF;
    private Debitos multaPagas;
    private Debitos multaDebitos;
    private Veiculo historicoDeLocacoes;
    private boolean aptoLocacao;
}
