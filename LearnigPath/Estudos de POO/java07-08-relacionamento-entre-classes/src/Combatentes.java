public class Combatentes {
    private String nome;
    private float peso;
    private String categoria;
    private short vitorias;
    private short derrotas;
    private short empates;

    public Combatentes(String nome, float peso, short vitorias, short empates, short derrotas) {
        this.nome = nome;
        this.peso = peso;
        setCategoria();
        this.vitorias = vitorias;
        this.empates = empates;
        this.derrotas = derrotas;
    }

    private void setCategoria() {
        if (this.peso < 52.2f || this.peso > 120.2) {
            this.categoria = "Inválido";
        } else if (this.peso <= 70.3f) {
            this.categoria = "leve";
        } else if (this.peso <= 83.9f) {
            this.categoria = "Médio";
        } else {
            this.categoria = "pesado";
        }
    }

    public void  apresentar() {
        System.out.println("Lutador " + getNome());
        System.out.println("Peso " + getPeso());
        System.out.println("Categoria " + getCategoria());
        System.out.println("Com " + getDerrotas() + "derrotas");
        System.out.println(getEmpates() + "Empates");
        System.out.println("Contando com " + getVitorias() + "vitórias em sua conta.");
    }

    public void status() {

    }

    public void setGanhar() {
        this.vitorias++;
    }

    public void setPerder() {
        this.derrotas++;
    }

    public void setEmpatar() {

    }

    public float getPeso() {
        return peso;
    }

    public short getDerrotas() {
        return derrotas;
    }

    public short getEmpates() {
        return empates;
    }

    public short getVitorias() {
        return vitorias;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getNome() {
        return nome;
    }
}