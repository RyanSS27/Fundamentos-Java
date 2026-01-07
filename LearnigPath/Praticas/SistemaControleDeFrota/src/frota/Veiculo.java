package frota;

public abstract class Veiculo implements InterfaceVeiculo {
    private static int qtdeVeiculos;

    // Atributos
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
    protected boolean emManutencao;
    private boolean limpo;
    private boolean quebrado;
    private boolean emCondicaoDeUso;
    private float quilometragem;

    public Veiculo(String marca, String modelo, float quilometragem, float capacidadeMaximaTanque, String categoria, int qtdeMaxOcupantes) {
        qtdeVeiculos++;
        this.modelo = modelo;
        this.marca = marca;
        this.categoria = categoria;
        this.qtdeMaxOcupantes = qtdeMaxOcupantes;
        this.capacidadeMaximaTanque = capacidadeMaximaTanque;
        this.quilometragem = quilometragem;
    }

    private void novoVeiculo() {
        qtdeVeiculos++;
    }

    protected void rodar(float quilometros) {
        limpo = false;
        emCondicaoDeUso = false;
        quilometragem += quilometros;
    }

    @Override
    public String abastecer(float litros) {
        if (getTanque() + litros > getCapacidadeMaximaTanque()) {
            float excedente = (getTanque() + litros) - getCapacidadeMaximaTanque();
            setTanque(getCapacidadeMaximaTanque());
            return """
                    ===========================================================
                                      RELATÓRIO ABASTECIMENTO
                    ===========================================================
                    A quantidade desejada excede a capacidade máxima do tanque.
                    Foram abastecidos: %.1fl
                    Excedente: %.1fl
                    Estado do tanque: 100%%
                    
                    """.formatted((litros - excedente), excedente);
        } else {
            setTanque(getTanque() + litros);
            return """
                    ===========================================================
                                      RELATÓRIO ABASTECIMENTO
                    ===========================================================
                    A quantidade desejada excede a capacidade máxima do tanque.
                    Foram abastecidos: %.1fl
                    Estado do tanque: %.1f%%
                    """.formatted(litros, getTanquePorcentagem());
        }
    }

    @Override
    public String abastecer(String minOuMax) {
        // Calc: tanque*100/capacidade < capacidade/3
        // REFATORE ESSA FUNÇÂO ATRIBUINDO A LÓGICA DAS MENSAGENS À Oficina
        if (minOuMax.equals("min")) {
            if (getTanque() >= getCapacidadeMaximaTanque()/3.0f) {
                return """
                        ===========================================================
                                          RELATÓRIO ABASTECIMENTO
                        ===========================================================
                        Tanque já contém combustível suficiente.
                        Abastecimento não necessário.
                        Estado do tanque: %.1f%%
                       """.formatted(getTanquePorcentagem());
            } else {
                // Fazer ele abastecer até o mínimo indicado
                float litrosAbastecidos = getCapacidadeMaximaTanque()/3 - getTanque();
                return """
                        ===========================================================
                                          RELATÓRIO ABASTECIMENTO
                        ===========================================================
                        Tanque com combustível suficente para locação.
                        Litros abastecidos: %.2f
                        Estado do tanque: %.1f%%
                        """.formatted(litrosAbastecidos, getTanquePorcentagem());
            }
        } else if (minOuMax.equals("max")) {
            float litrosAbastecidos = getCapacidadeMaximaTanque() - getTanque();
            setTanque(getTanque() + litrosAbastecidos);
            return """
                        ===========================================================
                                          RELATÓRIO ABASTECIMENTO
                        ===========================================================
                        Tanque cheio.
                        Litros abastecidos: %.2fl
                        Estado do tanque: %.1f%%
                       """.formatted(litrosAbastecidos, getTanquePorcentagem());
        } else {
            return "Entrada inválida. Entre com 'mas' ou 'min' para abastecer até\n" +
                    "a mínima condição viável para locação.";
        }
    }

    //Getters e Setters

    public static int getQtdeVeiculos() {
        return qtdeVeiculos;
    }

    public static void setQtdeVeiculos(int qtdeVeiculos) {
        Veiculo.qtdeVeiculos = qtdeVeiculos;
    }

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
        this.emCondicaoDeUso = (getTanquePorcentagem() >= 30.0f) && !this.emManutencao && this.limpo && !this.quebrado;
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

    public void setEmCondicaoDeUso(boolean emCondicaoDeUso) {
        this.emCondicaoDeUso = emCondicaoDeUso;
    }

    public double calcularValorComDesvalorizacao() {
        return this.valor * (1 - (this.taxaDesvalorizacao / 100.0));
    }
}
