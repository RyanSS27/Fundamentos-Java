package frota;

import utilitarios.Cliente;

public interface InterfaceVeiculo {
    public abstract float abastecer(float litros);
    public abstract void serConsertado();
    public abstract void lavar();
    public abstract void serAlugado(Cliente locatario);
    public abstract void retornar();
    /*
    Implementação futura
   */
}
