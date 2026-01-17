public class Empregado {
    public int id;
    public String name;
    public float salario;

    public void receberAumento(float porcentagem) {
        salario += salario*porcentagem/100.0f;
    }

    public Empregado(int id, String name, float salario) {
        this.id = id;
        this.name = name;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Empregado{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salario=" + salario +
                '}';
    }
}
