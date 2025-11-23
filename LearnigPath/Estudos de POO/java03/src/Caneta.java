public class Caneta {
    public String marca;
    public String cor;
    protected float ponta;
    private int carga = 100;
    private boolean aberta = false;

    public void mostrarCaneta() {
        System.out.printf("CANETA\nMarca: %s\nCor: %s\nPonta: %.2f\nCarga de: %d%%\nEstado: %s", this.marca, this.cor, this.ponta, this.carga, this.aberta ? "aberta" : "fechada");
    }

    void escrever() {
        if (!this.aberta) {
            System.out.println("[ERRO] A caneta está tampada, seu imbecil.");
        } else {
            System.out.println("Rabisquei");
            this.carga--;
        }
    }

    public void destampar() {
        this.aberta = true;
    }

    public void tampar() {
        this.aberta = false;
    }
}

