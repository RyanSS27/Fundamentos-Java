package frota;

public interface InterfaceVeiculo {
    public abstract float abastecer(float litros);
    public abstract void serConsertado();
    public abstract void lavar();

    /*
    Implementação futura
        public abstract void serAlugado(Cliente cliente, int tempo);
        public abstract void retornar();
   */
}
