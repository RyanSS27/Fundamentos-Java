package exercicio01;

public class Funcionario {
    private String nome;
    private double salarioBruto;
    private double salarioLiquido;
    private float imposto;


    public String aumento(float porcentagem) {
        this.salarioBruto = this.salarioBruto + (this.salarioBruto * porcentagem / 100);
        this.setSalarioLiquido();
        return """
                Aumento concluído. Salário atual: R$%f.
                """.formatted(this.salarioBruto);
    }

    public void setNome(String nome) {
        this.nome = nome.trim();
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
        this.setSalarioLiquido();
    }

    public void setSalarioLiquido() {
        this.salarioLiquido = salarioBruto - (salarioBruto * this.imposto);
    }

    public void setImposto(float imposto) {
        this.imposto = imposto/100;
        this.setSalarioLiquido();
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public float getImposto() {
        return imposto;
    }

    @Override
    public String toString() {
        return """
                FICHA DO FUNCIONÁRIO
                Nome: %s
                Salário bruto: R$%.2f
                Salário liquido: R$%.2f
                Imposto: %.2f
                """.formatted(getNome(), getSalarioBruto(), getSalarioLiquido(), getImposto()*100);
    }
}
