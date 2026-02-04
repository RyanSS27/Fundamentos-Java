package financeiro;

import repositorios.RepositorioDebitos;

import java.util.List;

public class ControleFinanceiro implements AcessoFinanceiro {
    RepositorioDebitos repositorioDebitos;

    public ControleFinanceiro(RepositorioDebitos repositorio) {
      repositorioDebitos = repositorio;
    }

    @Override
    public boolean isFinanceiramenteElegivel(long cpf) {
        List<Debitos> pendencias = repositorioDebitos.debitosGeraisCliente(cpf, false);
        // Se forem retornadas quaisquer cobranças relacionadas ao cpf não pagas, ele é inelegível
        if(!pendencias.isEmpty())
            return false;
        return true;
    }

    @Override
    public String pagarPendencias(long cpf, double pagamento) {
        // Retorna erro
        if (pagamento <= 0) return "Valor inválido";

        List<Debitos> pendencias = repositorioDebitos.debitosGeraisCliente(cpf, false);
        // Retorna 0 caso não haja pendências
        if(pendencias.isEmpty()) return "Não há pendências vinculadas a esse CPF.";

        pagamento = tentarPagarDebitos(pendencias, pagamento);

        double dividaAtual = 0.0;
        for(Debitos p : pendencias) {
            if (!p.isPaga()) dividaAtual += p.getValor();
        }
        if (dividaAtual == 0.0) {
            return "Divida paga com sucesso!" + (pagamento > 0? " Troco de R$ " + pagamento: " Sem troco");
        } else {
            return "Pagamento parcial realizado. Ainda deve: R$ " + dividaAtual;
        }
    }

    private double tentarPagarDebitos(List<Debitos> pendencias, double pagamento) {
        for (Debitos p : pendencias) {
            // Interrompe o loop caso o saldo acabe
            if (pagamento <= 0) break;

            double valorDivida = p.getValor();

            if (pagamento >= valorDivida) {
                // Paga tudo
                p.pagar(valorDivida);
                pagamento -= valorDivida;
            } else {
                // Paga o possível
                p.pagar(pagamento);
                pagamento = 0;
            }
        }

        return pagamento; // Retorna quanto sobrou
    }

    @Override
    public String pagarMultas(double pagamento, Multa multa) {
        return "";
    }

    @Override
    public String pagarPedidos(double pagamento, Pedido pedido) {
        return "";
    }
}
