package utilitarios;

import frota.Veiculo;

import java.util.ArrayList;
import java.util.List;

// deve receber também multas de trânsito e multa por ferrar com o carro ao fechar a conta
public class Cliente {
    private String nome;
    private long CPF;
    private List<Debitos> historicoPedidos = new ArrayList<>();
    private List<Debitos> multas = new ArrayList<>(); // Multas por danos ao patrimônio
    private boolean aptoLocacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

//    public Debitos getPedido() {
//        return new ArrayList<>(pedido.get((pedido.size()-1)));
//    }
//
    public void setPedido(Debitos pedido) {
        if (aptoLocacao) {
            this.historicoPedidos.add(pedido);
            setAptoLocacao();
        } else {
            System.out.println("Inápito para locação");
        }
    }
//
//    public Debitos getMultas() {
//        return multas;
//    }

    public void setMultas(Debitos multas) {
        this.multas.add(multas);
        setAptoLocacao();
    }

    public boolean isAptoLocacao() {
        return aptoLocacao;
    }

    public void setAptoLocacao() {
        int contagem = 0;
        for (Debitos p : historicoPedidos)
            if (!p.paga) {
                aptoLocacao = false;
                contagem++;
            }

        for (Debitos m : multas) {
            if (!m.paga) {
                aptoLocacao = false;
                contagem++;
            }
        }

        if (contagem == 0) aptoLocacao = true;
    }
}
