package utilitarios;

import frota.Veiculo;

import java.util.ArrayList;
import java.util.List;

// deve receber também multas de trânsito e multa por ferrar com o carro ao fechar a conta
public class Cliente {
    private String nome;
    private final long CPF;
    private List<Debitos> historicoPedidos = new ArrayList<>();
    private List<Debitos> multas = new ArrayList<>(); // Multas por danos ao patrimônio
    private boolean aptoLocacao;
    private double totalDebitos;

    public Cliente(String nome, long CPF) {
        this.nome = nome;
        this.CPF = CPF;
        this.atualizarDadosFinanceiros();
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
            atualizarDadosFinanceiros();
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
        atualizarDadosFinanceiros();
    }

    public boolean isAptoLocacao() {
        return aptoLocacao;
    }

    public void atualizarDadosFinanceiros() {
        aptoLocacao = true;
        this.totalDebitos = 0.0;
        for (Debitos p : historicoPedidos)
            if (!p.paga) {
                aptoLocacao = false;
                this.totalDebitos += p.getValor();
            }

        for (Debitos m : multas)
            if (!m.paga) {
                aptoLocacao = false;
                this.totalDebitos += m.getValor();
            }
    }

    public String realizarPagamento(double valorPagamento) {
        if (valorPagamento <= 0) return "Valor inválido.";

        double saldoParaGastar = valorPagamento;

        // 1. Tenta pagar os pedidos primeiro
        saldoParaGastar = tentarPagarLista(historicoPedidos, saldoParaGastar);

        // 2. Com o que sobrou, tenta pagar as multas
        saldoParaGastar = tentarPagarLista(multas, saldoParaGastar);

        atualizarDadosFinanceiros();

        double troco = saldoParaGastar;

        if (this.totalDebitos == 0) {
            if (troco > 0) {
                return "Dívidas quitadas! Seu troco: R$ " + troco;
            }
            return "Dívidas quitadas com sucesso.";
        } else {
            return "Pagamento parcial realizado. Ainda deve: R$ " + this.totalDebitos;
        }
    }

    private double tentarPagarLista(List<Debitos> listaDebitos, double saldo) {
        for (Debitos debito : listaDebitos) {
            // Interrompe o loop caso o direito acabe
            if (saldo <= 0) break;

            if (!debito.isPaga()) {
                double valorDivida = debito.getValor();

                if (saldo >= valorDivida) {
                    // Paga tudo
                    debito.pagar(valorDivida);
                    saldo -= valorDivida;
                } else {
                    // Paga o possível
                    debito.pagar(saldo);
                    saldo = 0;
                }
            }
        }
        return saldo; // Retorna quanto sobrou
    }
}
