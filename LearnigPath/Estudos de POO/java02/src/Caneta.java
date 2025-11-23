public class Caneta {
    String marca;
    String cor;
    float ponta;
    int carga;
    boolean aberta;

    void mostrarCaneta() {
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

    void destampar() {
        this.aberta = true;
    }

    void tampar() {
        this.aberta = false;
    }
}
