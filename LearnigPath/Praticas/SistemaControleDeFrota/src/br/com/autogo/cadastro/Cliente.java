package br.com.autogo.cadastro;

import br.com.autogo.financeiro.ServicoFinanceiro;

// deve receber também multas de trânsito e multa por ferrar com o carro ao fechar a conta
public class Cliente {
    private String nome;
    private final long CPF;
    private boolean aptoLocacao;
    private double totalDebitos;

    public Cliente(String nome, long CPF) {
        this.nome = nome;
        this.CPF = CPF;
        this.aptoLocacao = true;
        totalDebitos = 0.0;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCPF() {
        return CPF;
    }

    public boolean isAptoLocacao(ServicoFinanceiro controle) {
        atualizarDadosFinanceiros(controle);
        return aptoLocacao;
    }

    public void atualizarDadosFinanceiros(ServicoFinanceiro controle) {
            aptoLocacao = controle.isFinanceiramenteElegivel(getCPF());
            if (!aptoLocacao) setTotalDebitos(controle.calcularDebitos(getCPF()));
    }

    private void setTotalDebitos(double valor) {
        this.totalDebitos = valor;
    }

    public double getTotalDebitos(ServicoFinanceiro controle) {
        atualizarDadosFinanceiros(controle);
        return this.totalDebitos;
    }

    @Override
    public String toString() {
        return """
                ------- Cliente -------
                Nome: %s
                CPF: %d
                Apto a locação: %b
                -----------------------
                """.formatted(getNome(), getCPF(), aptoLocacao);
    }
}
