package frota;

public interface InterfaceVeiculo {
    public abstract String abastecer(float litros);
    /*
        Enche o tanque ao receber "max" e coloca o mínimo de combustível
        necessário para que o carro esteja apto ao uso (1/3 do tanque)
        ao receber "min"
    */

    public abstract String abastecer(String maxOuMin);
    public abstract void serConsertado();
    public abstract void lavar();

    /*
    Implementação futura
        public abstract void serAlugado(Cliente cliente, int tempo);
        public abstract void retornar();
   */
}
