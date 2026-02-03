package financeiro;

import frota.Veiculo;

public abstract class Debitos {
    protected Cliente cliente;
    protected Veiculo veiculoAlugado;
    protected double valor;
    protected String descricao;
    protected boolean paga;

    public Debitos(Cliente cliente, Veiculo veiculoAlugado, double valor, String descricao) {
        this.cliente = cliente;
        this.veiculoAlugado = veiculoAlugado;
        this.valor = valor;
        this.descricao = descricao;
        this.paga = false;
        cliente.setPedido(this);
    }

    @Override
    public abstract String toString();

    public String pagar(double pagamento) {
        if (pagamento <= 0) {
            return "Valor inválido";
        }

        if (pagamento < valor) {
            this.valor -= pagamento;
            return "Pagamento parcial realizado. Restam: R$ " + valor;
        } else if (pagamento == valor) {
            this.valor = 0;
            this.paga = true;
            return "Dívida quitada com sucesso!";
        } else {
            double troco = pagamento - valor;
            this.valor = 0;
            this.paga = true;
            return "Dívida quitada! Seu troco é: R$ " + troco;
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculoAlugado() {
        return veiculoAlugado;
    }

    public void setVeiculoAlugado(Veiculo veiculoAlugado) {
        this.veiculoAlugado = veiculoAlugado;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isPaga() {
        return paga;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }
}
