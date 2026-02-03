package frota;

import oficina.Oficina;
import financeiro.Cliente;

import java.lang.Comparable;

public class Veiculo implements InterfaceVeiculo, Comparable<Veiculo> {
    private static int qtdeVeiculosMembrosDaFrota;
    private static int qtdeVeiculosCategoriaA;
    private static int qtdeVeiculosCategoriaB;
    private static int qtdeVeiculosCategoriaC;

    // Atributos
    private String placa;
    private String marca;
    private String modelo;
    private String categoria;
    private float valor;
    private float taxaDesvalorizacao;
    /*
    A: Duas ou três rodas (motos, motonetas, triciclos).
    B: Veículos de passeio, SUVs, picapes, vans leves (até 3.500kg e 8 lugares).
    C: Caminhões e vans de carga (entre 3.500kg e 6.000kg).
     */
    private final int LIMITADOR_VELOCIDADE = 110;
    private int qtdeMaxOcupantes;
    private float capacidadeMaximaTanque;

    // Atributos de estado
    private float tanque; // litros vigentes
    private boolean emLocacao;
    protected boolean emManutencao;
    private boolean limpo;
    private boolean quebrado;
    private boolean emCondicaoDeUso;
    private int nivelDano;
    private float quilometragem;
    private Cliente locatario;

    public Veiculo(String marca, String modelo, String placa, float quilometragem, float capacidadeMaximaTanque, String categoria, int qtdeMaxOcupantes, float valor) {
        qtdeVeiculosMembrosDaFrota++;
        categoria = categoria.toUpperCase();
        switch (categoria) {
            case "A" -> qtdeVeiculosCategoriaA++;
            case "B" -> qtdeVeiculosCategoriaB++;
            case "C" -> qtdeVeiculosCategoriaC++;
            default -> {
                System.out.println("Erro. Categoria inválida.");
                return;
            }
        }
        this.placa = placa.toUpperCase();
        this.modelo = modelo;
        this.marca = marca;
        this.categoria = categoria;
        this.qtdeMaxOcupantes = qtdeMaxOcupantes;
        this.capacidadeMaximaTanque = capacidadeMaximaTanque;
        this.quilometragem = quilometragem;
        this.emLocacao = false;
        this.locatario = null;
        this.valor = valor;
    }

    protected void rodar(float quilometros) {
        limpo = false;
        emCondicaoDeUso = false;
        quilometragem += quilometros;
    }

    @Override
    public float abastecer(float litros) {
        float espacoLivre = capacidadeMaximaTanque - tanque;
        /*
            Nota particular:
            Pega o menor valor encontrado na comparação entre os 2 valores,
            assim, a quantidade desejada nunca vai ser maior que o espaço
            livre e a qtde de litros desejados nunca excederá a capacidade
            do tanque.
         */
        float litrosAbastecidos = Math.min(litros, espacoLivre);
        this.tanque += litrosAbastecidos;
        return litrosAbastecidos;
    }

    @Override
    public void serConsertado() {
        if (emManutencao && nivelDano != 10) {
            this.nivelDano = 0;
            this.quebrado = false;
        }
    }

    @Override
    public void lavar() {
        if(emManutencao) {
            setLimpo(true);
        }
    }

    @Override
    public void serAlugado(Cliente locatario) {
        if (isEmCondicaoDeUso()) {
            setEmLocacao(true);
            setLocatario(locatario);
            this.setLimpo(false);
            setEmCondicaoDeUso();
        } else {
            System.out.println("O veículo não pode ser alugado.");
        }
    }

    @Override
    public void retornar() {
        this.setEmLocacao(false);
        this.setLimpo(false);
        this.setEmCondicaoDeUso();
    }

    @Override
    public int compareTo(Veiculo veiculoComparado) {
        return this.getModelo().compareTo(veiculoComparado.getModelo());
    }

    @Override
    public String toString() {
        return " %s, %s - Placa [%s] (categoria: %s)".formatted(
                this.getMarca(),
                this.getModelo(),
                this.getPlaca(),
                this.getCategoria()
                );
    }

    //Getters e Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getLIMITADOR_VELOCIDADE() {
        return LIMITADOR_VELOCIDADE;
    }

    public int getQtdeMaxOcupantes() {
        return qtdeMaxOcupantes;
    }

    public void setQtdeMaxOcupantes(int qtdeMaxOcupantes) {
        this.qtdeMaxOcupantes = qtdeMaxOcupantes;
    }

    public float getCapacidadeMaximaTanque() {
        return capacidadeMaximaTanque;
    }

    public void setCapacidadeMaximaTanque(float capacidadeMaximaTanque) {
        this.capacidadeMaximaTanque = capacidadeMaximaTanque;
    }

    // Retorna a porcentagem preenchida do tanque
    public float getTanquePorcentagem() {
        // Retorna a porcentagem
        return this.tanque*100/this.capacidadeMaximaTanque;
    }

    // Retorna quantos litros tem no tanque
    public float getTanque() {
        // Retorna litros
        return this.tanque;
    }

    public void setTanque(float tanque) {
        this.tanque = tanque;
    }

    public boolean isEmManutencao() {
        return emManutencao;
    }

    public void setEmManutencao(boolean emManutencao) {
        this.emManutencao = emManutencao;
    }

    public boolean isLimpo() {
        return limpo;
    }

    public void setLimpo(boolean limpo) {
        this.limpo = limpo;
    }

    public boolean isQuebrado() {
        return quebrado;
    }

    public void setQuebrado(boolean quebrado) {
        this.quebrado = quebrado;
    }

    public boolean isEmCondicaoDeUso() {
        this.setEmCondicaoDeUso();
        return emCondicaoDeUso;
    }

    public void setEmCondicaoDeUso() {
        this.emCondicaoDeUso = (getTanquePorcentagem() >= (Oficina.CAPACIDADE_MINIMA_GASOLINA_LOCACAO * 10)) && !this.emManutencao && this.limpo && !this.quebrado && !emLocacao;
    }

    public float getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(float quilometragem) {
        this.quilometragem = quilometragem;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getTaxaDesvalorizacao() {
        return taxaDesvalorizacao;
    }

    public void setTaxaDesvalorizacao(float taxaDesvalorizacao) {
        this.taxaDesvalorizacao = taxaDesvalorizacao;
    }

    public double calcularValorComDesvalorizacao() {
        return this.valor * (1 - (this.taxaDesvalorizacao / 100.0));
    }

    public int getNivelDano() {
        return nivelDano;
    }

    public void setNivelDano(int nivelDano) {
        this.nivelDano = nivelDano;
        if (nivelDano > 0) {
            quebrado = true;
        }
    }

    public void setPlaca(String placa) {
        this.placa = placa.toUpperCase();
    }

    public String getPlaca() {
        return this.placa.toUpperCase();
    }

    public boolean isEmLocacao() {
        return emLocacao;
    }

    public void setEmLocacao(boolean emLocacao) {
        this.emLocacao = emLocacao;
    }

    public Cliente getLocatario() {
        return locatario;
    }

    public void setLocatario(Cliente locatario) {
        this.locatario = locatario;
    }
}
