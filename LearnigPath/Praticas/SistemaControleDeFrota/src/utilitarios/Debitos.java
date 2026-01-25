package utilitarios;

import frota.Veiculo;

public abstract class Debitos {
    protected Cliente cliente;
    protected Veiculo veiculoAlugado;
    protected float valor;
    protected String descricao;
    protected boolean paga;

    public Debitos(Cliente cliente, Veiculo veiculoAlugado, float valor, String descricao) {
        this.cliente = cliente;
        this.veiculoAlugado = veiculoAlugado;
        this.valor = valor;
        this.descricao = descricao;
        this.paga = false;
    }

    @Override
    public abstract String toString();

    public void pagar(float pagamento) {
        if (pagamento <= 0) {
            
        }
    }
}
