package utilitarios;

import frota.Veiculo;

import java.util.ArrayList;
import java.util.List;

// deve receber também multas de trânsito e multa por ferrar com o carro ao fechar a conta
public class Cliente {
    private String nome;
    private int CPF;
    private List<Debitos> pedido = new ArrayList<>();
    private List<Debitos> multas = new ArrayList<>(); // Multas por danos ao patrimônio
    private boolean aptoLocacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public Debitos getPedido() {
        return new ArrayList<>(pedido);
    }

    public void setPedido(Debitos pedido) {
        this.pedido = pedido;
    }

    public Debitos getMultas() {
        return multas;
    }

    public void setMultas(Debitos multas) {
        this.multas.add(multas);
    }

    public boolean isAptoLocacao() {
        return aptoLocacao;
    }

    public void setAptoLocacao(boolean aptoLocacao) {
        aptoLocacao = !this.multas.isEmpty() ? false: true;
    }
}
