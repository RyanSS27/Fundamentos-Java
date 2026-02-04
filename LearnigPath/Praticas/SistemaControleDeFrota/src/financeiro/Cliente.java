package financeiro;

import java.util.ArrayList;
import java.util.List;

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

    public boolean isAptoLocacao(ControleFinanceiro controle) {
        atualizarDadosFinanceiros(controle);
        return aptoLocacao;
    }

    public void atualizarDadosFinanceiros(ControleFinanceiro controle) {
            aptoLocacao = controle.isFinanceiramenteElegivel(getCPF());
    }
}
