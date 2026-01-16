package exercicioGerirEstoque;

public class Produtos {
    private String nome;
    private String descricao;
    private float preco;
    private int qtdeEstoque;

    public Produtos(String nome, String descricao, float preco, int qtdeEstoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdeEstoque = qtdeEstoque;
    }

    @Override
    public String toString() {
        return  "Nome: " + nome + '\n' +
                "Descrição: " + descricao + '\n' +
                "Preço: " + preco + '\n' +
                "Quantidade em estoque: " + qtdeEstoque;
    }

    public boolean serVendido(float pagamento, int quantidade) {
        if (quantidade > qtdeEstoque || pagamento < (preco*quantidade)) {
            return false;
        }

        setQtdeEstoque(getQtdeEstoque()-quantidade);
        return true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setQtdeEstoque(int qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }
}
